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
 * The ModuleDefinition resource defines the data requirements for a quality artifact.
 * 
 * <p>Java class for ModuleDefinition.CodeFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModuleDefinition.CodeFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="path" type="{http://hl7.org/fhir}string"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="valueSetString" type="{http://hl7.org/fhir}string"/>
 *           &lt;element name="valueSetReference" type="{http://hl7.org/fhir}Reference"/>
 *         &lt;/choice>
 *         &lt;element name="codeableConcept" type="{http://hl7.org/fhir}CodeableConcept" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModuleDefinition.CodeFilter", propOrder = {
    "path",
    "valueSetString",
    "valueSetReference",
    "codeableConcept"
})
@javax.xml.bind.annotation.XmlRootElement(name="ModuleDefinitionCodeFilter") 
public class ModuleDefinitionCodeFilter
    extends BackboneElement
{

    @XmlElement(required = true)
    protected String path;
    protected String valueSetString;
    protected Reference valueSetReference;
    protected List<CodeableConcept> codeableConcept;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Gets the value of the valueSetString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueSetString() {
        return valueSetString;
    }

    /**
     * Sets the value of the valueSetString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueSetString(String value) {
        this.valueSetString = value;
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

    /**
     * Gets the value of the codeableConcept property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codeableConcept property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodeableConcept().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeableConcept }
     * 
     * 
     */
    public List<CodeableConcept> getCodeableConcept() {
        if (codeableConcept == null) {
            codeableConcept = new ArrayList<CodeableConcept>();
        }
        return this.codeableConcept;
    }

}
