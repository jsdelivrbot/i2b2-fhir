//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.30 at 02:43:29 AM EST 
//


package org.hl7.fhir;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * If the element is present, it must have either a @value, an @id, or extensions
 * 
 * <p>Java class for FamilyMemberHistory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FamilyMemberHistory">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}DomainResource">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://hl7.org/fhir}Identifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="patient" type="{http://hl7.org/fhir}Reference"/>
 *         &lt;element name="date" type="{http://hl7.org/fhir}dateTime" minOccurs="0"/>
 *         &lt;element name="status" type="{http://hl7.org/fhir}FamilyHistoryStatus"/>
 *         &lt;element name="name" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="relationship" type="{http://hl7.org/fhir}CodeableConcept"/>
 *         &lt;element name="gender" type="{http://hl7.org/fhir}code" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="bornPeriod" type="{http://hl7.org/fhir}Period"/>
 *           &lt;element name="bornDate" type="{http://hl7.org/fhir}date"/>
 *           &lt;element name="bornString" type="{http://hl7.org/fhir}string"/>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="ageQuantity" type="{http://hl7.org/fhir}Age"/>
 *           &lt;element name="ageRange" type="{http://hl7.org/fhir}Range"/>
 *           &lt;element name="ageString" type="{http://hl7.org/fhir}string"/>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="deceasedBoolean" type="{http://hl7.org/fhir}boolean"/>
 *           &lt;element name="deceasedQuantity" type="{http://hl7.org/fhir}Age"/>
 *           &lt;element name="deceasedRange" type="{http://hl7.org/fhir}Range"/>
 *           &lt;element name="deceasedDate" type="{http://hl7.org/fhir}date"/>
 *           &lt;element name="deceasedString" type="{http://hl7.org/fhir}string"/>
 *         &lt;/choice>
 *         &lt;element name="note" type="{http://hl7.org/fhir}Annotation" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://hl7.org/fhir}FamilyMemberHistory.Condition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FamilyMemberHistory", propOrder = {
    "identifier",
    "patient",
    "date",
    "status",
    "name",
    "relationship",
    "gender",
    "bornPeriod",
    "bornDate",
    "bornString",
    "ageQuantity",
    "ageRange",
    "ageString",
    "deceasedBoolean",
    "deceasedQuantity",
    "deceasedRange",
    "deceasedDate",
    "deceasedString",
    "note",
    "condition"
})
@javax.xml.bind.annotation.XmlRootElement(name="FamilyMemberHistory") 
public class FamilyMemberHistory
    extends DomainResource
{

    protected List<Identifier> identifier;
    @XmlElement(required = true)
    protected Reference patient;
    protected DateTime date;
    @XmlElement(required = true)
    protected FamilyHistoryStatus status;
    protected String name;
    @XmlElement(required = true)
    protected CodeableConcept relationship;
    protected Code gender;
    protected Period bornPeriod;
    protected Date bornDate;
    protected String bornString;
    protected Age ageQuantity;
    protected Range ageRange;
    protected String ageString;
    protected Boolean deceasedBoolean;
    protected Age deceasedQuantity;
    protected Range deceasedRange;
    protected Date deceasedDate;
    protected String deceasedString;
    protected Annotation note;
    protected List<FamilyMemberHistoryCondition> condition;

    /**
     * Gets the value of the identifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Identifier }
     * 
     * 
     */
    public List<Identifier> getIdentifier() {
        if (identifier == null) {
            identifier = new ArrayList<Identifier>();
        }
        return this.identifier;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setPatient(Reference value) {
        this.patient = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setDate(DateTime value) {
        this.date = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link FamilyHistoryStatus }
     *     
     */
    public FamilyHistoryStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link FamilyHistoryStatus }
     *     
     */
    public void setStatus(FamilyHistoryStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * @return
     *     possible object is
     *     {@link CodeableConcept }
     *     
     */
    public CodeableConcept getRelationship() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeableConcept }
     *     
     */
    public void setRelationship(CodeableConcept value) {
        this.relationship = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setGender(Code value) {
        this.gender = value;
    }

    /**
     * Gets the value of the bornPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getBornPeriod() {
        return bornPeriod;
    }

    /**
     * Sets the value of the bornPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setBornPeriod(Period value) {
        this.bornPeriod = value;
    }

    /**
     * Gets the value of the bornDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getBornDate() {
        return bornDate;
    }

    /**
     * Sets the value of the bornDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setBornDate(Date value) {
        this.bornDate = value;
    }

    /**
     * Gets the value of the bornString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBornString() {
        return bornString;
    }

    /**
     * Sets the value of the bornString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBornString(String value) {
        this.bornString = value;
    }

    /**
     * Gets the value of the ageQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Age }
     *     
     */
    public Age getAgeQuantity() {
        return ageQuantity;
    }

    /**
     * Sets the value of the ageQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Age }
     *     
     */
    public void setAgeQuantity(Age value) {
        this.ageQuantity = value;
    }

    /**
     * Gets the value of the ageRange property.
     * 
     * @return
     *     possible object is
     *     {@link Range }
     *     
     */
    public Range getAgeRange() {
        return ageRange;
    }

    /**
     * Sets the value of the ageRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Range }
     *     
     */
    public void setAgeRange(Range value) {
        this.ageRange = value;
    }

    /**
     * Gets the value of the ageString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeString() {
        return ageString;
    }

    /**
     * Sets the value of the ageString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeString(String value) {
        this.ageString = value;
    }

    /**
     * Gets the value of the deceasedBoolean property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDeceasedBoolean() {
        return deceasedBoolean;
    }

    /**
     * Sets the value of the deceasedBoolean property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeceasedBoolean(Boolean value) {
        this.deceasedBoolean = value;
    }

    /**
     * Gets the value of the deceasedQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Age }
     *     
     */
    public Age getDeceasedQuantity() {
        return deceasedQuantity;
    }

    /**
     * Sets the value of the deceasedQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Age }
     *     
     */
    public void setDeceasedQuantity(Age value) {
        this.deceasedQuantity = value;
    }

    /**
     * Gets the value of the deceasedRange property.
     * 
     * @return
     *     possible object is
     *     {@link Range }
     *     
     */
    public Range getDeceasedRange() {
        return deceasedRange;
    }

    /**
     * Sets the value of the deceasedRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Range }
     *     
     */
    public void setDeceasedRange(Range value) {
        this.deceasedRange = value;
    }

    /**
     * Gets the value of the deceasedDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDeceasedDate() {
        return deceasedDate;
    }

    /**
     * Sets the value of the deceasedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDeceasedDate(Date value) {
        this.deceasedDate = value;
    }

    /**
     * Gets the value of the deceasedString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeceasedString() {
        return deceasedString;
    }

    /**
     * Sets the value of the deceasedString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeceasedString(String value) {
        this.deceasedString = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setNote(Annotation value) {
        this.note = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the condition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FamilyMemberHistoryCondition }
     * 
     * 
     */
    public List<FamilyMemberHistoryCondition> getCondition() {
        if (condition == null) {
            condition = new ArrayList<FamilyMemberHistoryCondition>();
        }
        return this.condition;
    }

}
