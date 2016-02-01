//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.30 at 02:43:29 AM EST 
//


package org.hl7.fhir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency was notified about a reportable condition.
 * 
 * <p>Java class for Communication.Payload complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Communication.Payload">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="contentString" type="{http://hl7.org/fhir}string"/>
 *           &lt;element name="contentAttachment" type="{http://hl7.org/fhir}Attachment"/>
 *           &lt;element name="contentReference" type="{http://hl7.org/fhir}Reference"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Communication.Payload", propOrder = {
    "contentString",
    "contentAttachment",
    "contentReference"
})
@javax.xml.bind.annotation.XmlRootElement(name="CommunicationPayload") 
public class CommunicationPayload
    extends BackboneElement
{

    protected String contentString;
    protected Attachment contentAttachment;
    protected Reference contentReference;

    /**
     * Gets the value of the contentString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentString() {
        return contentString;
    }

    /**
     * Sets the value of the contentString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentString(String value) {
        this.contentString = value;
    }

    /**
     * Gets the value of the contentAttachment property.
     * 
     * @return
     *     possible object is
     *     {@link Attachment }
     *     
     */
    public Attachment getContentAttachment() {
        return contentAttachment;
    }

    /**
     * Sets the value of the contentAttachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Attachment }
     *     
     */
    public void setContentAttachment(Attachment value) {
        this.contentAttachment = value;
    }

    /**
     * Gets the value of the contentReference property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getContentReference() {
        return contentReference;
    }

    /**
     * Sets the value of the contentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setContentReference(Reference value) {
        this.contentReference = value;
    }

}
