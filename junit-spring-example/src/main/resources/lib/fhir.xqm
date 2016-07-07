module namespace f="http://fhir.i2b2.org/modules/fhirBase";

declare function f:all-whitespace
  (
   $arg as xs:string? 
)  as xs:boolean {

   normalize-space(
    $arg
  ) = ''
 } ;
 
declare function f:fnSQLTimeToFhirTime(
  $r as xs:string?
) as xs:string{
   
  let $x :=fn:replace(
    $r,'.000Z$',''
  ) 
  let $x :=fn:replace(
    $x,' ','T'
  )
  return fn:concat(
    $x,'+05:00'
  )
  
}; 

declare function f:fnSQLTimeToID(
  $pid as xs:string?,$cat as xs:string?, $r as xs:string? 
) as xs:string{
   
 

let $rnum := random:integer()
  let $x :=fn:replace(
    $r,'.000Z$',''
  ) 
  let $x :=fn:replace(
    $x,' ','T'
  )
  (:let $x := fn:concat(
    $pid,"-",$cat,"-",$x,$rnum
  ):)
   let $x := fn:concat(
    $pid,"-",$rnum
  )
   let $x :=fn:replace(
    $x,':',''
  )
  let $x :=fn:replace(
    $x,'0\.',''
  )
  return fn:replace(
    $x,' ','-'
  )
}; 
 
 declare function f:fnFhirValueQuantity(
  $val as xs:string?,$unit as xs:string?
) as node(){
      
let $unitStr:=
       if(
    f:all-whitespace(
      $unit
    )
  ) then ""
        else $unit
 
return <valueQuantity>
    <value value="{
    $val
  }"/>    
    <system value="http://unitsofmeasure.org"/>
    <unit value="{
    $unitStr
  }"/>  
    <code value="{
    $unitStr
  }"/> 
    
    
  </valueQuantity>
};

declare function f:fnFhirValueCodeableConcept(
  $val as xs:string?
) as node(){
<valueCodeableConcept>
    <coding>
      <system value="http://i2b2.org"/>
      <code value="{
    $val
  }"/>
      <display value="{
    $val
  }"/>
    </coding>
  </valueCodeableConcept>
};

 declare function f:fnFhirObservation(
   $sd as xs:string?, $ed as xs:string?,$oid as xs:string,$cn as xs:string, $cid as xs:string, $pid as xs:string, $valueFhir as node()?
) as node(){
       
  let $endDateString:=
    if(
    $ed != ""
  ) then
    <end value="{
    $ed
  }"/>
  else ()
   let $cn_display_str:=
  if(
    f:all-whitespace(
      $cn
    )
  ) then ""
   else   <display value="{
    $cn
  }"/> 
   
   let $cid:=fn:replace(
    $cid,"LOINC:",""
  )

return
  <Observation xmlns="http://hl7.org/fhir"  xmlns:ns2="http://www.w3.org/1999/xhtml">
 <id value="{
    $oid
  }"/>
    <text>
        <status value="generated"/>
        <div xmlns="http://www.w3.org/1999/xhtml">
        <p>{
    $cn
  }</p>
        <p>{
    $cid
  }</p>
        <p>{
    (
      $valueFhir//@value/string())
  }</p>
        </div>
    </text>
  
    <code>  
        <coding>
           <system value="http://loinc.org"/>
           <code value="{
    $cid
  }"/>
           {
    $cn_display_str
  }
           <primary value="true"/>
        </coding>
    </code>
  
 <effectiveDateTime value="{
    $sd
  }"/>
    {
    $valueFhir
  }
  <!--   the mandatory quality flags:   -->
  <status value="final"/>
  <reliability value="ok"/>
  
   <subject>
     <reference value="Patient/a{
    $pid
  }"/>
  </subject>

  </Observation>
  
};