//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.30 at 02:43:29 AM EST 
//


package org.hl7.fhir;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModuleMetadataType-list.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ModuleMetadataType-list">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="module"/>
 *     &lt;enumeration value="library"/>
 *     &lt;enumeration value="decision-support-rule"/>
 *     &lt;enumeration value="documentation-template"/>
 *     &lt;enumeration value="order-set"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ModuleMetadataType-list")
@XmlEnum
public enum ModuleMetadataTypeList {


    /**
     * The resource is a description of a knowledge module
     * 
     */
    @XmlEnumValue("module")
    MODULE("module"),

    /**
     * The resource is a shareable library of formalized knowledge
     * 
     */
    @XmlEnumValue("library")
    LIBRARY("library"),

    /**
     * An Event-Condition-Action Rule Artifact
     * 
     */
    @XmlEnumValue("decision-support-rule")
    DECISION_SUPPORT_RULE("decision-support-rule"),

    /**
     * A Documentation Template Artifact
     * 
     */
    @XmlEnumValue("documentation-template")
    DOCUMENTATION_TEMPLATE("documentation-template"),

    /**
     * An Order Set Artifact
     * 
     */
    @XmlEnumValue("order-set")
    ORDER_SET("order-set");
    private final java.lang.String value;

    ModuleMetadataTypeList(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ModuleMetadataTypeList fromValue(java.lang.String v) {
        for (ModuleMetadataTypeList c: ModuleMetadataTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
