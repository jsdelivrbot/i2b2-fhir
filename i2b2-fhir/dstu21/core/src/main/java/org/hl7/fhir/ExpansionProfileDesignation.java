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
 * Resource to define constraints on the Expansion of a FHIR ValueSet.
 * 
 * <p>Java class for ExpansionProfile.Designation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpansionProfile.Designation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="include" type="{http://hl7.org/fhir}ExpansionProfile.Include1" minOccurs="0"/>
 *         &lt;element name="exclude" type="{http://hl7.org/fhir}ExpansionProfile.Exclude1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExpansionProfile.Designation", propOrder = {
    "include",
    "exclude"
})
@javax.xml.bind.annotation.XmlRootElement(name="ExpansionProfileDesignation") 
public class ExpansionProfileDesignation
    extends BackboneElement
{

    protected ExpansionProfileInclude1 include;
    protected ExpansionProfileExclude1 exclude;

    /**
     * Gets the value of the include property.
     * 
     * @return
     *     possible object is
     *     {@link ExpansionProfileInclude1 }
     *     
     */
    public ExpansionProfileInclude1 getInclude() {
        return include;
    }

    /**
     * Sets the value of the include property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpansionProfileInclude1 }
     *     
     */
    public void setInclude(ExpansionProfileInclude1 value) {
        this.include = value;
    }

    /**
     * Gets the value of the exclude property.
     * 
     * @return
     *     possible object is
     *     {@link ExpansionProfileExclude1 }
     *     
     */
    public ExpansionProfileExclude1 getExclude() {
        return exclude;
    }

    /**
     * Sets the value of the exclude property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpansionProfileExclude1 }
     *     
     */
    public void setExclude(ExpansionProfileExclude1 value) {
        this.exclude = value;
    }

}
