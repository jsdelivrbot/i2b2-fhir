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
 * <p>Java class for AppointmentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppointmentResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}DomainResource">
 *       &lt;sequence>
 *         &lt;element name="identifier" type="{http://hl7.org/fhir}Identifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="appointment" type="{http://hl7.org/fhir}Reference"/>
 *         &lt;element name="start" type="{http://hl7.org/fhir}instant" minOccurs="0"/>
 *         &lt;element name="end" type="{http://hl7.org/fhir}instant" minOccurs="0"/>
 *         &lt;element name="participantType" type="{http://hl7.org/fhir}CodeableConcept" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="actor" type="{http://hl7.org/fhir}Reference" minOccurs="0"/>
 *         &lt;element name="participantStatus" type="{http://hl7.org/fhir}ParticipantStatus"/>
 *         &lt;element name="comment" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppointmentResponse", propOrder = {
    "identifier",
    "appointment",
    "start",
    "end",
    "participantType",
    "actor",
    "participantStatus",
    "comment"
})
@javax.xml.bind.annotation.XmlRootElement(name="AppointmentResponse") 
public class AppointmentResponse
    extends DomainResource
{

    protected List<Identifier> identifier;
    @XmlElement(required = true)
    protected Reference appointment;
    protected Instant start;
    protected Instant end;
    protected List<CodeableConcept> participantType;
    protected Reference actor;
    @XmlElement(required = true)
    protected ParticipantStatus participantStatus;
    protected String comment;

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
     * Gets the value of the appointment property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getAppointment() {
        return appointment;
    }

    /**
     * Sets the value of the appointment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setAppointment(Reference value) {
        this.appointment = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Instant }
     *     
     */
    public Instant getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instant }
     *     
     */
    public void setStart(Instant value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link Instant }
     *     
     */
    public Instant getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instant }
     *     
     */
    public void setEnd(Instant value) {
        this.end = value;
    }

    /**
     * Gets the value of the participantType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participantType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipantType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeableConcept }
     * 
     * 
     */
    public List<CodeableConcept> getParticipantType() {
        if (participantType == null) {
            participantType = new ArrayList<CodeableConcept>();
        }
        return this.participantType;
    }

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setActor(Reference value) {
        this.actor = value;
    }

    /**
     * Gets the value of the participantStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantStatus }
     *     
     */
    public ParticipantStatus getParticipantStatus() {
        return participantStatus;
    }

    /**
     * Sets the value of the participantStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantStatus }
     *     
     */
    public void setParticipantStatus(ParticipantStatus value) {
        this.participantStatus = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
