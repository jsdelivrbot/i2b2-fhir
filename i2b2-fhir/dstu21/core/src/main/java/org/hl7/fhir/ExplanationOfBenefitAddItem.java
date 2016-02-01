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
 * <p>Java class for ExplanationOfBenefit.AddItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExplanationOfBenefit.AddItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="sequenceLinkId" type="{http://hl7.org/fhir}positiveInt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="service" type="{http://hl7.org/fhir}Coding"/>
 *         &lt;element name="fee" type="{http://hl7.org/fhir}Money" minOccurs="0"/>
 *         &lt;element name="noteNumberLinkId" type="{http://hl7.org/fhir}positiveInt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adjudication" type="{http://hl7.org/fhir}ExplanationOfBenefit.Adjudication3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="detail" type="{http://hl7.org/fhir}ExplanationOfBenefit.Detail1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExplanationOfBenefit.AddItem", propOrder = {
    "sequenceLinkId",
    "service",
    "fee",
    "noteNumberLinkId",
    "adjudication",
    "detail"
})
@javax.xml.bind.annotation.XmlRootElement(name="ExplanationOfBenefitAddItem") 
public class ExplanationOfBenefitAddItem
    extends BackboneElement
{

    protected List<PositiveInt> sequenceLinkId;
    @XmlElement(required = true)
    protected Coding service;
    protected Money fee;
    protected List<PositiveInt> noteNumberLinkId;
    protected List<ExplanationOfBenefitAdjudication3> adjudication;
    protected List<ExplanationOfBenefitDetail1> detail;

    /**
     * Gets the value of the sequenceLinkId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sequenceLinkId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSequenceLinkId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PositiveInt }
     * 
     * 
     */
    public List<PositiveInt> getSequenceLinkId() {
        if (sequenceLinkId == null) {
            sequenceLinkId = new ArrayList<PositiveInt>();
        }
        return this.sequenceLinkId;
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
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setFee(Money value) {
        this.fee = value;
    }

    /**
     * Gets the value of the noteNumberLinkId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noteNumberLinkId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoteNumberLinkId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PositiveInt }
     * 
     * 
     */
    public List<PositiveInt> getNoteNumberLinkId() {
        if (noteNumberLinkId == null) {
            noteNumberLinkId = new ArrayList<PositiveInt>();
        }
        return this.noteNumberLinkId;
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
     * {@link ExplanationOfBenefitAdjudication3 }
     * 
     * 
     */
    public List<ExplanationOfBenefitAdjudication3> getAdjudication() {
        if (adjudication == null) {
            adjudication = new ArrayList<ExplanationOfBenefitAdjudication3>();
        }
        return this.adjudication;
    }

    /**
     * Gets the value of the detail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExplanationOfBenefitDetail1 }
     * 
     * 
     */
    public List<ExplanationOfBenefitDetail1> getDetail() {
        if (detail == null) {
            detail = new ArrayList<ExplanationOfBenefitDetail1>();
        }
        return this.detail;
    }

}
