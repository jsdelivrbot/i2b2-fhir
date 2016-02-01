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
 * <p>Java class for TransactionMode-list.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionMode-list">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="not-supported"/>
 *     &lt;enumeration value="batch"/>
 *     &lt;enumeration value="transaction"/>
 *     &lt;enumeration value="both"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionMode-list")
@XmlEnum
public enum TransactionModeList {


    /**
     * Neither batch or transaction is supported.
     * 
     */
    @XmlEnumValue("not-supported")
    NOT_SUPPORTED("not-supported"),

    /**
     * Batches are  supported.
     * 
     */
    @XmlEnumValue("batch")
    BATCH("batch"),

    /**
     * Transactions are supported.
     * 
     */
    @XmlEnumValue("transaction")
    TRANSACTION("transaction"),

    /**
     * Both batches and transactions are supported.
     * 
     */
    @XmlEnumValue("both")
    BOTH("both");
    private final java.lang.String value;

    TransactionModeList(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static TransactionModeList fromValue(java.lang.String v) {
        for (TransactionModeList c: TransactionModeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
