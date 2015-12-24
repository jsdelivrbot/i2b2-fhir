declare namespace  ns2="http://www.i2b2.org/xsd/hive/pdo/1.1/";
declare namespace map="http://www.w3.org/2005/xpath-functions/map";

declare function local:fnI2b2TimeToFhirTime($r as xs:string?) as xs:string{ 
fn:replace($r,'.000Z$','') 
};

declare function local:getIdentifier() as node(){ 

 <identifier>
    <use value="usual"/>
    <label value="MRN"/>
    <system value="urn:oid:1.2.36.146.595.217.0.1"/>
    <value value="12345"/>
    <period>
      <start value="2001-05-06"/>
    </period>
    <assigner>
      <display value="Acme Healthcare"/>
    </assigner>
  </identifier>

};

declare function local:fnrace($r as xs:string?) as xs:string
{ 
(:let $map := map:map()
let $key := map:put($map, "black", "B")
let $f:=map:get($map,$r)
return $f
:)
if ($r="aleutian")  then  "2009-9"
    else  if ($r="american indian") then "1004-1"
    else  if ($r="asian") then "2028-9"
    else  if ($r="asian pacific islander") then "2076-8"
    else  if ($r="eskimo") then "1840-8"
    else  if ($r="hispanic") then "UNK"
    (:XXX unlcear what race to map hispanics to 
    https://hl7-fhir.github.io/valueset-daf-race.html
    current unknown
    :)
    else  if ($r="indian") then "1004-1"
    else  if ($r="middle eastern") then "2118-8"
    else  if ($r="multiracial") then "UNK"
    else if ($r="native american") then "1004-1"
    else  if ($r="navajo") then "UNK"
    else  if ($r="not recorded") then "UNK"
    else  if ($r="oriental") then "UNK"
    else   if ($r="white") then "2106-3"
    else "UNK"
};

declare function local:fnMaritalStatus($r as xs:string?) as xs:string
{ 
if ($r="common law")  then  "T"
(:XXX mapped to domestic partner) :)
else if ($r="divorced")  then  "D"
else if ($r="married")  then  "M"
else if ($r="other")  then  "UNK"
else if ($r="partner")  then  "T"
else if ($r="seperated")  then  "L"
else if ($r="unknown")  then  "UNK" 
else if ($r="widowed") then "W"
else if ($r="single") then "S"
else "UNK"
};

declare function local:fnMetaData($last_updated as xs:string? ) as node(){
<MetaData>
    <lastUpdated>{$last_updated}</lastUpdated>
</MetaData>
};

declare function local:fnTxt($label as xs:string,$x as xs:string?){
      
         <tr>
            <td>{$label}</td>
            <td>{$x}</td>
          </tr>
};




declare function local:fnPatient($zip as xs:string?,
                                 $id as xs:string?,
                                  $gender as xs:string?,
                                 $gender_expanded as xs:string?,
                                 $birthdate as xs:string?,
                                 $marital_status as xs:string?,
                                 $marital_status_raw as xs:string?,
                                 $race_code as xs:string?
) as node()?{
<Patient  namespace="http://hl7.org/fhir"  >
  <id value="{$id}"/>
  <text>
    <status value="generated"/>
    <div xmlns="http://www.w3.org/1999/xhtml">
      <table>
        <tbody>
          <tr>
            <td>Id</td>
            <td>{$id}</td>
          </tr>
          {local:fnTxt('Zip',$zip)}
          {local:fnTxt('Gender',$gender_expanded)}
          {local:fnTxt('BirthDate',$birthdate)}
          {local:fnTxt('Marital Status',$marital_status_raw)}
   
        </tbody>
      </table>
    </div>
  </text>
  
  <name>
    <use value="anonymous"/>
    <family value="anonymous"/>
    <given value="anonymous"/>
  </name>
  
<!--  {$local:getIdentifier()}-->
 
<identifier>
    <use value="usual"/>
    <type>
      <coding>
        <system value="http://hl7.org/fhir/v2/0203"/>
        <code value="MR"/>
      </coding>
    </type>
    <system value="urn:oid:1.2.36.146.595.217.0.1"/>
    <value value="{$id}"/>
    <assigner>
      <display value="i2b2"/>
    </assigner>
  </identifier>
 
  <!--   use FHIR code system for male / female   -->
  <gender value="{$gender_expanded}"/>
  <birthDate value="{$birthdate}"/>
  <deceasedBoolean value="false"/>
  
  <extension url="http://hl7.org/fhir/StructureDefinition/us-core-race">
    <valueCodeableConcept>
      <coding>
        <system value="http://hl7.org/fhir/v3/Race"/>
        <code value="{$race_code}"/>
        <primary value="true"/>
      </coding>
    </valueCodeableConcept>
  </extension>
  <address>
    <use value="home"/>
    <zip value="{$zip}"/>
  </address>

  <managingOrganization>
    <reference value="Organization/1"/>
  </managingOrganization>
  
  <maritalStatus>
    <coding>
      <system value="http://hl7.org/fhir/v3/MaritalStatus"/>
      <code value="{$marital_status}"/>
      <display value="{$marital_status_raw}"/>
    </coding>
   </maritalStatus>
   
   
  <active value="true"/>

</Patient>
};

let $I:=root()(:doc('/Users/kbw19/git/res/i2b2-fhir/dstu2/xquery-2/src/main/resources/example/i2b2/AllPatients.xml'):)

let $O:=
for $p in  $I//ns2:patient_set/patient
let $id:=$p/patient_id/text()
let $zip:=$p/param[(@column='zip_cd')]/text()
let $gender:=$p/param[(@column='sex_cd')]/text()
let $gender_expanded:=if ($gender='M') then 'male' else 'female'
let $marital_status_raw:=$p/param[(@column='marital_status_cd')]/text()
let $marital_status:=local:fnMaritalStatus(fn:lower-case($marital_status_raw))
let $race_code:=local:fnrace(fn:lower-case($p/param[(@column='race')]/text()))
let $birthdate:=$p/param[(@column='birth_date')]/text()
let $updateDate := local:fnI2b2TimeToFhirTime($p/@update_date)

return 
<entry  xmlns="http://hl7.org/fhir">
    <resource>
{local:fnPatient($zip, $id,$gender,$gender_expanded,$birthdate,$marital_status,$marital_status_raw,$race_code )}
    </resource>
</entry>

return <Bundle xmlns:ns2="http://www.w3.org/1999/xhtml" xmlns="http://hl7.org/fhir">
    {$O}
    </Bundle>

