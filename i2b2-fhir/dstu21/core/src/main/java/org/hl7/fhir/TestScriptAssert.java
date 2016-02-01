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
 * TestScript is a resource that specifies a suite of tests against a FHIR server implementation to determine compliance against the FHIR specification.
 * 
 * <p>Java class for TestScript.Assert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestScript.Assert">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hl7.org/fhir}BackboneElement">
 *       &lt;sequence>
 *         &lt;element name="label" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="direction" type="{http://hl7.org/fhir}AssertionDirectionType" minOccurs="0"/>
 *         &lt;element name="compareToSourceId" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="compareToSourcePath" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="contentType" type="{http://hl7.org/fhir}ContentType" minOccurs="0"/>
 *         &lt;element name="headerField" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="minimumId" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="navigationLinks" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://hl7.org/fhir}AssertionOperatorType" minOccurs="0"/>
 *         &lt;element name="path" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="resource" type="{http://hl7.org/fhir}code" minOccurs="0"/>
 *         &lt;element name="response" type="{http://hl7.org/fhir}AssertionResponseTypes" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="sourceId" type="{http://hl7.org/fhir}id" minOccurs="0"/>
 *         &lt;element name="validateProfileId" type="{http://hl7.org/fhir}id" minOccurs="0"/>
 *         &lt;element name="value" type="{http://hl7.org/fhir}string" minOccurs="0"/>
 *         &lt;element name="warningOnly" type="{http://hl7.org/fhir}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestScript.Assert", propOrder = {
    "label",
    "description",
    "direction",
    "compareToSourceId",
    "compareToSourcePath",
    "contentType",
    "headerField",
    "minimumId",
    "navigationLinks",
    "operator",
    "path",
    "resource",
    "response",
    "responseCode",
    "sourceId",
    "validateProfileId",
    "value",
    "warningOnly"
})
@javax.xml.bind.annotation.XmlRootElement(name="TestScriptAssert") 
public class TestScriptAssert
    extends BackboneElement
{

    protected String label;
    protected String description;
    protected AssertionDirectionType direction;
    protected String compareToSourceId;
    protected String compareToSourcePath;
    protected ContentType contentType;
    protected String headerField;
    protected String minimumId;
    protected Boolean navigationLinks;
    protected AssertionOperatorType operator;
    protected String path;
    protected Code resource;
    protected AssertionResponseTypes response;
    protected String responseCode;
    protected Id sourceId;
    protected Id validateProfileId;
    protected String value;
    protected Boolean warningOnly;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link AssertionDirectionType }
     *     
     */
    public AssertionDirectionType getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionDirectionType }
     *     
     */
    public void setDirection(AssertionDirectionType value) {
        this.direction = value;
    }

    /**
     * Gets the value of the compareToSourceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompareToSourceId() {
        return compareToSourceId;
    }

    /**
     * Sets the value of the compareToSourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompareToSourceId(String value) {
        this.compareToSourceId = value;
    }

    /**
     * Gets the value of the compareToSourcePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompareToSourcePath() {
        return compareToSourcePath;
    }

    /**
     * Sets the value of the compareToSourcePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompareToSourcePath(String value) {
        this.compareToSourcePath = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link ContentType }
     *     
     */
    public ContentType getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentType }
     *     
     */
    public void setContentType(ContentType value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the headerField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderField() {
        return headerField;
    }

    /**
     * Sets the value of the headerField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderField(String value) {
        this.headerField = value;
    }

    /**
     * Gets the value of the minimumId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimumId() {
        return minimumId;
    }

    /**
     * Sets the value of the minimumId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimumId(String value) {
        this.minimumId = value;
    }

    /**
     * Gets the value of the navigationLinks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getNavigationLinks() {
        return navigationLinks;
    }

    /**
     * Sets the value of the navigationLinks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNavigationLinks(Boolean value) {
        this.navigationLinks = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link AssertionOperatorType }
     *     
     */
    public AssertionOperatorType getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionOperatorType }
     *     
     */
    public void setOperator(AssertionOperatorType value) {
        this.operator = value;
    }

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
     * Gets the value of the resource property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setResource(Code value) {
        this.resource = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link AssertionResponseTypes }
     *     
     */
    public AssertionResponseTypes getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionResponseTypes }
     *     
     */
    public void setResponse(AssertionResponseTypes value) {
        this.response = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the sourceId property.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getSourceId() {
        return sourceId;
    }

    /**
     * Sets the value of the sourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setSourceId(Id value) {
        this.sourceId = value;
    }

    /**
     * Gets the value of the validateProfileId property.
     * 
     * @return
     *     possible object is
     *     {@link Id }
     *     
     */
    public Id getValidateProfileId() {
        return validateProfileId;
    }

    /**
     * Sets the value of the validateProfileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Id }
     *     
     */
    public void setValidateProfileId(Id value) {
        this.validateProfileId = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the warningOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWarningOnly() {
        return warningOnly;
    }

    /**
     * Sets the value of the warningOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWarningOnly(Boolean value) {
        this.warningOnly = value;
    }

}
