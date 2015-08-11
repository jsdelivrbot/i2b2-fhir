/*
 * Copyright (c) 2006-2007 Massachusetts General Hospital 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the i2b2 Software License v1.0 
 * which accompanies this distribution. 
 * 
 * Contributors:
 * 		Kavishwar Wagholikar (kavi)
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.25 at 02:29:55 PM EDT 
//


package org.hl7.fhir;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A conformance statement is a set of requirements for a desired implementation or a description of how a target application fulfills those requirements in a particular implementation.
 * 
 * <p>Java class for Conformance.Resource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Conformance.Resource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://hl7.org/fhir}code"/>
 *         &lt;element name="profile" type="{http://hl7.org/fhir}Reference" minOccurs="0"/>
 *         &lt;element name="interaction" type="{http://hl7.org/fhir}Conformance.Interaction" maxOccurs="unbounded"/>
 *         &lt;element name="versioning" type="{http://hl7.org/fhir}ResourceVersionPolicy" minOccurs="0"/>
 *         &lt;element name="readHistory" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="updateCreate" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="conditionalCreate" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="conditionalUpdate" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="conditionalDelete" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="searchInclude" type="{http://hl7.org/fhir}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="searchParam" type="{http://hl7.org/fhir}Conformance.SearchParam" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Conformance.Resource", propOrder = {
    "type",
    "profile",
    "interaction",
    "versioning",
    "readHistory",
    "updateCreate",
    "conditionalCreate",
    "conditionalUpdate",
    "conditionalDelete",
    "searchInclude",
    "searchParam"
})
public class ConformanceResource
    extends BackboneElement
{

    @XmlElement(required = true)
    protected Code type;
    protected Reference profile;
    @XmlElement(required = true)
    protected List<ConformanceInteraction> interaction;
    protected ResourceVersionPolicy versioning;
    protected Boolean readHistory;
    protected Boolean updateCreate;
    protected Boolean conditionalCreate;
    protected Boolean conditionalUpdate;
    protected Boolean conditionalDelete;
    protected List<String> searchInclude;
    protected List<ConformanceSearchParam> searchParam;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setType(Code value) {
        this.type = value;
    }

    /**
     * Gets the value of the profile property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getProfile() {
        return profile;
    }

    /**
     * Sets the value of the profile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setProfile(Reference value) {
        this.profile = value;
    }

    /**
     * Gets the value of the interaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteraction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConformanceInteraction }
     * 
     * 
     */
    public List<ConformanceInteraction> getInteraction() {
        if (interaction == null) {
            interaction = new ArrayList<ConformanceInteraction>();
        }
        return this.interaction;
    }

    /**
     * Gets the value of the versioning property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceVersionPolicy }
     *     
     */
    public ResourceVersionPolicy getVersioning() {
        return versioning;
    }

    /**
     * Sets the value of the versioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceVersionPolicy }
     *     
     */
    public void setVersioning(ResourceVersionPolicy value) {
        this.versioning = value;
    }

    /**
     * Gets the value of the readHistory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getReadHistory() {
        return readHistory;
    }

    /**
     * Sets the value of the readHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadHistory(Boolean value) {
        this.readHistory = value;
    }

    /**
     * Gets the value of the updateCreate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getUpdateCreate() {
        return updateCreate;
    }

    /**
     * Sets the value of the updateCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUpdateCreate(Boolean value) {
        this.updateCreate = value;
    }

    /**
     * Gets the value of the conditionalCreate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getConditionalCreate() {
        return conditionalCreate;
    }

    /**
     * Sets the value of the conditionalCreate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConditionalCreate(Boolean value) {
        this.conditionalCreate = value;
    }

    /**
     * Gets the value of the conditionalUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getConditionalUpdate() {
        return conditionalUpdate;
    }

    /**
     * Sets the value of the conditionalUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConditionalUpdate(Boolean value) {
        this.conditionalUpdate = value;
    }

    /**
     * Gets the value of the conditionalDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getConditionalDelete() {
        return conditionalDelete;
    }

    /**
     * Sets the value of the conditionalDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConditionalDelete(Boolean value) {
        this.conditionalDelete = value;
    }

    /**
     * Gets the value of the searchInclude property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchInclude property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchInclude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSearchInclude() {
        if (searchInclude == null) {
            searchInclude = new ArrayList<String>();
        }
        return this.searchInclude;
    }

    /**
     * Gets the value of the searchParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConformanceSearchParam }
     * 
     * 
     */
    public List<ConformanceSearchParam> getSearchParam() {
        if (searchParam == null) {
            searchParam = new ArrayList<ConformanceSearchParam>();
        }
        return this.searchParam;
    }

}