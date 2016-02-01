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
 * <p>Java class for OrderSetItemGroupingBehavior-list.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderSetItemGroupingBehavior-list">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="visual-group"/>
 *     &lt;enumeration value="logical-group"/>
 *     &lt;enumeration value="sentence-group"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrderSetItemGroupingBehavior-list")
@XmlEnum
public enum OrderSetItemGroupingBehaviorList {


    /**
     * Any group marked with this behavior should be displayed as a visual group to the end user
     * 
     */
    @XmlEnumValue("visual-group")
    VISUAL_GROUP("visual-group"),

    /**
     * A group with this behavior logically groups its sub-elements, and may be shown as a visual group to the end user, but it is not required to do so
     * 
     */
    @XmlEnumValue("logical-group")
    LOGICAL_GROUP("logical-group"),

    /**
     * A group of related alternative items is a sentence group if the target referenced by the item is the same in all the items, and each item simply constitutes a different variation on how to specify the details for the target. For example, two items that could be in a SentenceGroup are "aspirin, 500 mg, 2 times per day" and "aspirin, 300 mg, 3 times per day". In both cases, aspirin is the target referenced by the item, and the two items represent two different options for how aspirin might be ordered for the patient. Note that a SentenceGroup would almost always have an associated selection behavior of "AtMostOne", unless it's a required item, in which case, it would be "ExactlyOne"
     * 
     */
    @XmlEnumValue("sentence-group")
    SENTENCE_GROUP("sentence-group");
    private final java.lang.String value;

    OrderSetItemGroupingBehaviorList(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static OrderSetItemGroupingBehaviorList fromValue(java.lang.String v) {
        for (OrderSetItemGroupingBehaviorList c: OrderSetItemGroupingBehaviorList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
