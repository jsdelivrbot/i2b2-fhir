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
 * <p>Java class for ProfileOriginType-list.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProfileOriginType-list">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FHIR-DSTU2-Client"/>
 *     &lt;enumeration value="FHIR-DSTU2-SDC-FormFiller"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ProfileOriginType-list")
@XmlEnum
public enum ProfileOriginTypeList {


    /**
     * General DSTU2 client initiating against a DSTU2 Server.
     * 
     */
    @XmlEnumValue("FHIR-DSTU2-Client")
    FHIR_DSTU_2_CLIENT("FHIR-DSTU2-Client"),

    /**
     * DSTU2 client that serves as an SDC-FormFiller.
     * 
     */
    @XmlEnumValue("FHIR-DSTU2-SDC-FormFiller")
    FHIR_DSTU_2_SDC_FORM_FILLER("FHIR-DSTU2-SDC-FormFiller");
    private final java.lang.String value;

    ProfileOriginTypeList(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static ProfileOriginTypeList fromValue(java.lang.String v) {
        for (ProfileOriginTypeList c: ProfileOriginTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}