/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.jbpmn.spec.extend;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.netbeans.jbpmn.spec.TBaseElement;
import org.netbeans.jbpmn.spec.TDataState;

/**
 * <p>
 * Java class for tDataInput complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * <complexType name="tDataInput">
 *   <complexContent>
 *     <extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tBaseElement">
 *       <sequence>
 *         <element ref="{http://www.omg.org/spec/BPMN/20100524/MODEL}dataState" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="itemSubjectRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       <attribute name="isCollection" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * </pre>
 *
 *
 */
@XmlType(propOrder = {
    "dataState"
})
public class TDataParam
        extends TBaseElement {

    protected TDataState dataState;
    @XmlAttribute
    protected String name;
    @XmlAttribute
//    protected QName itemSubjectRef;
    protected String itemSubjectRef;
    @XmlAttribute
    protected Boolean isCollection;

    /**
     * Gets the value of the dataState property.
     *
     * @return possible object is {@link TDataState }
     *
     */
    public TDataState getDataState() {
        return dataState;
    }

    /**
     * Sets the value of the dataState property.
     *
     * @param value allowed object is {@link TDataState }
     *
     */
    public void setDataState(TDataState value) {
        this.dataState = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the itemSubjectRef property.
     *
     * @return possible object is {@link QName }
     *
     */
    public String getItemSubjectRef() {
        return itemSubjectRef;
    }

    /**
     * Sets the value of the itemSubjectRef property.
     *
     * @param value allowed object is {@link QName }
     *
     */
    public void setItemSubjectRef(String value) {
        this.itemSubjectRef = value;
    }

    /**
     * Gets the value of the isCollection property.
     *
     * @return possible object is {@link Boolean }
     *
     */
    public boolean isIsCollection() {
        if (isCollection == null) {
            return false;
        } else {
            return isCollection;
        }
    }

    /**
     * Sets the value of the isCollection property.
     *
     * @param value allowed object is {@link Boolean }
     *
     */
    public void setIsCollection(Boolean value) {
        this.isCollection = value;
    }

}
