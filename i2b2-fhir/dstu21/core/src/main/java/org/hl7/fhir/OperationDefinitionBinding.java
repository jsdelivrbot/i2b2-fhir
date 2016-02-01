//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.30 at 02:43:29 AM EST 
//


package org.hl7.fhir;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
 * 
 * <p>Java class for OperationDefinition.Binding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationDefinition.Binding">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="strength" type="{http://hl7.org/fhir}code"/>
 *         &lt;choice>
 *           &lt;element name="valueSetUri" type="{http://hl7.org/fhir}uri"/>
 *           &lt;element name="valueSetReference" type="{http://hl7.org/fhir}Reference"/>
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
@XmlType(name = "OperationDefinition.Binding", propOrder = {
    "strength",
    "valueSetUri",
    "valueSetReference"
})
@javax.xml.bind.annotation.XmlRootElement(name="OperationDefinitionBinding") 
public class OperationDefinitionBinding
    extends BackboneElement
{

    @XmlElement(required = true)
    protected Code strength;
    protected Uri valueSetUri;
    protected Reference valueSetReference;

    /**
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setStrength(Code value) {
        this.strength = value;
    }

    /**
     * Gets the value of the valueSetUri property.
     * 
     * @return
     *     possible object is
     *     {@link Uri }
     *     
     */
    public Uri getValueSetUri() {
        return valueSetUri;
    }

    /**
     * Sets the value of the valueSetUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uri }
     *     
     */
    public void setValueSetUri(Uri value) {
        this.valueSetUri = value;
    }

    /**
     * Gets the value of the valueSetReference property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getValueSetReference() {
        return valueSetReference;
    }

    /**
     * Sets the value of the valueSetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setValueSetReference(Reference value) {
        this.valueSetReference = value;
    }

}
