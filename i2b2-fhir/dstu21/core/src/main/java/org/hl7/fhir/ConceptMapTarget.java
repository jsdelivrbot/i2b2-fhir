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
 * A statement of relationships from one set of concepts to one or more other concepts - either code systems or data elements, or classes in class models.
 * 
 * <p>Java class for ConceptMap.Target complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConceptMap.Target">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="codeSystem" type="{http://hl7.org/fhir}uri" minOccurs="0"/>
 *         &lt;element name="code" type="{http://hl7.org/fhir}code" minOccurs="0"/>
 *         &lt;element name="equivalence" type="{http://hl7.org/fhir}code"/>
 *         &lt;element name="comments" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="dependsOn" type="{http://hl7.org/fhir}ConceptMap.DependsOn" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="product" type="{http://hl7.org/fhir}ConceptMap.DependsOn" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConceptMap.Target", propOrder = {
    "codeSystem",
    "code",
    "equivalence",
    "comments",
    "dependsOn",
    "product"
})
@javax.xml.bind.annotation.XmlRootElement(name="ConceptMapTarget") 
public class ConceptMapTarget
    extends BackboneElement
{

    protected Uri codeSystem;
    protected Code code;
    @XmlElement(required = true)
    protected Code equivalence;
    protected String comments;
    protected List<ConceptMapDependsOn> dependsOn;
    protected List<ConceptMapDependsOn> product;

    /**
     * Gets the value of the codeSystem property.
     * 
     * @return
     *     possible object is
     *     {@link Uri }
     *     
     */
    public Uri getCodeSystem() {
        return codeSystem;
    }

    /**
     * Sets the value of the codeSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Uri }
     *     
     */
    public void setCodeSystem(Uri value) {
        this.codeSystem = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setCode(Code value) {
        this.code = value;
    }

    /**
     * Gets the value of the equivalence property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getEquivalence() {
        return equivalence;
    }

    /**
     * Sets the value of the equivalence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setEquivalence(Code value) {
        this.equivalence = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the dependsOn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependsOn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependsOn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConceptMapDependsOn }
     * 
     * 
     */
    public List<ConceptMapDependsOn> getDependsOn() {
        if (dependsOn == null) {
            dependsOn = new ArrayList<ConceptMapDependsOn>();
        }
        return this.dependsOn;
    }

    /**
     * Gets the value of the product property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the product property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConceptMapDependsOn }
     * 
     * 
     */
    public List<ConceptMapDependsOn> getProduct() {
        if (product == null) {
            product = new ArrayList<ConceptMapDependsOn>();
        }
        return this.product;
    }

}
