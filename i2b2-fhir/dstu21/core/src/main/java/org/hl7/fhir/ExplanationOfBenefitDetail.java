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
 * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
 * 
 * <p>Java class for ExplanationOfBenefit.Detail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExplanationOfBenefit.Detail">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="sequence" type="{http://hl7.org/fhir}positiveInt"/>
 *         &lt;element name="type" type="{http://hl7.org/fhir}Coding"/>
 *         &lt;element name="service" type="{http://hl7.org/fhir}Coding"/>
 *         &lt;element name="quantity" type="{http://hl7.org/fhir}SimpleQuantity" minOccurs="0"/>
 *         &lt;element name="unitPrice" type="{http://hl7.org/fhir}Money" minOccurs="0"/>
 *         &lt;element name="factor" type="{http://hl7.org/fhir}decimal" minOccurs="0"/>
 *         &lt;element name="points" type="{http://hl7.org/fhir}decimal" minOccurs="0"/>
 *         &lt;element name="net" type="{http://hl7.org/fhir}Money" minOccurs="0"/>
 *         &lt;element name="udi" type="{http://hl7.org/fhir}Coding" minOccurs="0"/>
 *         &lt;element name="adjudication" type="{http://hl7.org/fhir}ExplanationOfBenefit.Adjudication1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subDetail" type="{http://hl7.org/fhir}ExplanationOfBenefit.SubDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExplanationOfBenefit.Detail", propOrder = {
    "sequence",
    "type",
    "service",
    "quantity",
    "unitPrice",
    "factor",
    "points",
    "net",
    "udi",
    "adjudication",
    "subDetail"
})
@javax.xml.bind.annotation.XmlRootElement(name="ExplanationOfBenefitDetail") 
public class ExplanationOfBenefitDetail
    extends BackboneElement
{

    @XmlElement(required = true)
    protected PositiveInt sequence;
    @XmlElement(required = true)
    protected Coding type;
    @XmlElement(required = true)
    protected Coding service;
    protected SimpleQuantity quantity;
    protected Money unitPrice;
    protected Decimal factor;
    protected Decimal points;
    protected Money net;
    protected Coding udi;
    protected List<ExplanationOfBenefitAdjudication1> adjudication;
    protected List<ExplanationOfBenefitSubDetail> subDetail;

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link PositiveInt }
     *     
     */
    public PositiveInt getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link PositiveInt }
     *     
     */
    public void setSequence(PositiveInt value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Coding }
     *     
     */
    public Coding getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coding }
     *     
     */
    public void setType(Coding value) {
        this.type = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link Coding }
     *     
     */
    public Coding getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coding }
     *     
     */
    public void setService(Coding value) {
        this.service = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleQuantity }
     *     
     */
    public SimpleQuantity getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleQuantity }
     *     
     */
    public void setQuantity(SimpleQuantity value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setUnitPrice(Money value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the factor property.
     * 
     * @return
     *     possible object is
     *     {@link Decimal }
     *     
     */
    public Decimal getFactor() {
        return factor;
    }

    /**
     * Sets the value of the factor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Decimal }
     *     
     */
    public void setFactor(Decimal value) {
        this.factor = value;
    }

    /**
     * Gets the value of the points property.
     * 
     * @return
     *     possible object is
     *     {@link Decimal }
     *     
     */
    public Decimal getPoints() {
        return points;
    }

    /**
     * Sets the value of the points property.
     * 
     * @param value
     *     allowed object is
     *     {@link Decimal }
     *     
     */
    public void setPoints(Decimal value) {
        this.points = value;
    }

    /**
     * Gets the value of the net property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getNet() {
        return net;
    }

    /**
     * Sets the value of the net property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setNet(Money value) {
        this.net = value;
    }

    /**
     * Gets the value of the udi property.
     * 
     * @return
     *     possible object is
     *     {@link Coding }
     *     
     */
    public Coding getUdi() {
        return udi;
    }

    /**
     * Sets the value of the udi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coding }
     *     
     */
    public void setUdi(Coding value) {
        this.udi = value;
    }

    /**
     * Gets the value of the adjudication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjudication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjudication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExplanationOfBenefitAdjudication1 }
     * 
     * 
     */
    public List<ExplanationOfBenefitAdjudication1> getAdjudication() {
        if (adjudication == null) {
            adjudication = new ArrayList<ExplanationOfBenefitAdjudication1>();
        }
        return this.adjudication;
    }

    /**
     * Gets the value of the subDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExplanationOfBenefitSubDetail }
     * 
     * 
     */
    public List<ExplanationOfBenefitSubDetail> getSubDetail() {
        if (subDetail == null) {
            subDetail = new ArrayList<ExplanationOfBenefitSubDetail>();
        }
        return this.subDetail;
    }

}
