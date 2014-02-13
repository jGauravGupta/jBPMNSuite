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
package org.netbeans.jbpmn.modeler.widget.properties.itemdefinition;

import javax.swing.JOptionPane;
import org.netbeans.jbpmn.spec.TDefinitions;
import org.netbeans.jbpmn.spec.TItemDefinition;
import org.netbeans.jbpmn.spec.TItemKind;
import org.netbeans.modeler.core.NBModelerUtil;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.ComboBoxValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.Entity;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.RowValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.internal.EntityComponent;

public class ItemDefinitionPanel extends EntityComponent<TItemDefinition> {

// private ComboBoxValue<TItemDefinition> comboBoxValue;
    private ModelerFile modelerFile;
    private TDefinitions definition;

    /**
     * Creates new form CreateErrorPanel
     */
    public ItemDefinitionPanel(ModelerFile modelerFile) {
        super("", true);
        this.modelerFile = modelerFile;
        definition = (TDefinitions) modelerFile.getDefinitionElement();
        initComponents();
    }

    @Override
    public void init() {
        itemKind_ComboBox.removeAllItems();
        itemKind_ComboBox.addItem(TItemKind.INFORMATION);
        itemKind_ComboBox.addItem(TItemKind.PHYSICAL);
    }

    @Override
    public void createEntity(Class<? extends Entity> entityWrapperType) {
        this.setTitle("Create new Data Type");
        if (entityWrapperType == ComboBoxValue.class) {
            this.setEntity(new ComboBoxValue<TItemDefinition>());
        } else if (entityWrapperType == RowValue.class) {
            this.setEntity(new RowValue(new Object[4]));
        }
        itemKind_ComboBox.setSelectedItem(TItemKind.INFORMATION);
        isCollection_CheckBox.setSelected(false);
        dataType_TextField.setText("");
        isCollection_CheckBox.setEnabled(true);
        dataType_TextField.setEnabled(true);
        browse_Button.setEnabled(true);
    }

    @Override
    public void updateEntity(Entity<TItemDefinition> entityValue) {
        this.setTitle("Update Data Type");
        this.setEntity(entityValue);
        TItemDefinition itemDefinition = null;
        if (entityValue.getClass() == ComboBoxValue.class) {
            itemDefinition = ((ComboBoxValue<TItemDefinition>) entityValue).getValue();
        } else if (entityValue.getClass() == RowValue.class) {
            Object[] row = ((RowValue) entityValue).getRow();
            itemDefinition = (TItemDefinition) row[0];
        }
        itemKind_ComboBox.setSelectedItem(itemDefinition.getItemKind());
        isCollection_CheckBox.setSelected(itemDefinition.isIsCollection());
        dataType_TextField.setText(itemDefinition.getStructureRef());
        isCollection_CheckBox.setEnabled(false);
        dataType_TextField.setEnabled(false);
        browse_Button.setEnabled(false);

        //            name_TextField.setText(itemDefinition.getName() == null ? "" : itemDefinition.getName());
        //            code_TextField.setText(itemDefinition.getErrorCode() == null ? "" : itemDefinition.getErrorCode());
        //
        //            TItemDefinition itemDefinition = definition.findItemDefinition(itemDefinition.getStructureRef());
        //            dataType_TextField.setText(itemDefinition == null ? "" : itemDefinition.getStructureRef());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLayeredPane1 = new javax.swing.JLayeredPane();
        itemKind_LayeredPane = new javax.swing.JLayeredPane();
        itemKind_Label = new javax.swing.JLabel();
        itemKind_ComboBox = new javax.swing.JComboBox();
        isCollection_LayeredPane = new javax.swing.JLayeredPane();
        isCollection_Label = new javax.swing.JLabel();
        isCollection_CheckBox = new javax.swing.JCheckBox();
        dataType_LayeredPane = new javax.swing.JLayeredPane();
        dataType_Label = new javax.swing.JLabel();
        dataType_TextField = new javax.swing.JTextField();
        actionType_LayeredPane = new javax.swing.JLayeredPane();
        save_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();
        browse_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(itemKind_Label, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.itemKind_Label.text")); // NOI18N
        itemKind_LayeredPane.add(itemKind_Label);
        itemKind_Label.setBounds(0, 0, 90, 14);

        itemKind_LayeredPane.add(itemKind_ComboBox);
        itemKind_ComboBox.setBounds(90, 0, 250, 20);

        jLayeredPane1.add(itemKind_LayeredPane);
        itemKind_LayeredPane.setBounds(20, 20, 340, 30);

        org.openide.awt.Mnemonics.setLocalizedText(isCollection_Label, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.isCollection_Label.text")); // NOI18N
        isCollection_LayeredPane.add(isCollection_Label);
        isCollection_Label.setBounds(0, 0, 90, 14);

        org.openide.awt.Mnemonics.setLocalizedText(isCollection_CheckBox, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.isCollection_CheckBox.text")); // NOI18N
        isCollection_CheckBox.setToolTipText(org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.isCollection_CheckBox.toolTipText")); // NOI18N
        isCollection_LayeredPane.add(isCollection_CheckBox);
        isCollection_CheckBox.setBounds(90, 0, 21, 21);

        jLayeredPane1.add(isCollection_LayeredPane);
        isCollection_LayeredPane.setBounds(20, 60, 340, 30);

        org.openide.awt.Mnemonics.setLocalizedText(dataType_Label, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.dataType_Label.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dataType_TextField, org.jdesktop.beansbinding.ObjectProperty.create(), dataType_Label, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        dataType_LayeredPane.add(dataType_Label);
        dataType_Label.setBounds(0, 0, 90, 14);

        dataType_TextField.setText(org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.dataType_TextField.text")); // NOI18N
        dataType_TextField.setToolTipText(org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.dataType_TextField.toolTipText")); // NOI18N
        dataType_LayeredPane.add(dataType_TextField);
        dataType_TextField.setBounds(90, 0, 250, 20);

        jLayeredPane1.add(dataType_LayeredPane);
        dataType_LayeredPane.setBounds(20, 100, 350, 40);

        org.openide.awt.Mnemonics.setLocalizedText(save_Button, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.save_Button.text")); // NOI18N
        save_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.save_Button.toolTipText")); // NOI18N
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });
        actionType_LayeredPane.add(save_Button);
        save_Button.setBounds(0, 0, 57, 23);

        org.openide.awt.Mnemonics.setLocalizedText(cancel_Button, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.cancel_Button.text")); // NOI18N
        cancel_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.cancel_Button.toolTipText")); // NOI18N
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });
        actionType_LayeredPane.add(cancel_Button);
        cancel_Button.setBounds(70, 0, 73, 23);

        jLayeredPane1.add(actionType_LayeredPane);
        actionType_LayeredPane.setBounds(220, 140, 150, 30);

        browse_Button.setBackground(new java.awt.Color(255, 255, 255));
        browse_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/jbpmn/modeler/widget/properties/resource/searchbutton.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(browse_Button, org.openide.util.NbBundle.getMessage(ItemDefinitionPanel.class, "ItemDefinitionPanel.browse_Button.text")); // NOI18N
        browse_Button.setBorder(null);
        browse_Button.setBorderPainted(false);
        browse_Button.setContentAreaFilled(false);
        browse_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse_ButtonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(browse_Button);
        browse_Button.setBounds(370, 100, 25, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean validateField() {
        if (this.dataType_TextField.getText().trim().length() <= 0 /*|| Pattern.compile("[^\\w-]").matcher(this.id_TextField.getText().trim()).find()*/) {
            JOptionPane.showMessageDialog(this, "Parameter Data Type can't be empty", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }//I18n

        return true;
    }

    void setItemDefinitionId(TItemDefinition itemDefinition) {
        String id;
        if (itemDefinition.isIsCollection()) {
            id = itemDefinition.getStructureRef() + "[]";
        } else {
            id = itemDefinition.getStructureRef();
        }
        itemDefinition.setId(id);
    }
    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        if (!validateField()) {
            return;
        }
        TItemDefinition itemDefinition = null;
//set Object Value
        if (this.getEntity().getClass() == ComboBoxValue.class) {
            ComboBoxValue<TItemDefinition> comboBoxValue = (ComboBoxValue<TItemDefinition>) this.getEntity();
            if (comboBoxValue.getValue() == null) {
                itemDefinition = new TItemDefinition();
                itemDefinition.setIsCollection(isCollection_CheckBox.isSelected());
                itemDefinition.setStructureRef(dataType_TextField.getText().trim());
                itemDefinition.setItemKind((TItemKind) itemKind_ComboBox.getSelectedItem());

                setItemDefinitionId(itemDefinition);
            } else {
                itemDefinition = comboBoxValue.getValue();
                itemDefinition.setItemKind((TItemKind) itemKind_ComboBox.getSelectedItem());

            }

        } else if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            if (row[0] == null) {
                itemDefinition = new TItemDefinition();
                itemDefinition.setIsCollection(isCollection_CheckBox.isSelected());
                itemDefinition.setStructureRef(dataType_TextField.getText().trim());
                itemDefinition.setItemKind((TItemKind) itemKind_ComboBox.getSelectedItem());

                setItemDefinitionId(itemDefinition);
            } else {
                itemDefinition = (TItemDefinition) row[0];
                itemDefinition.setItemKind((TItemKind) itemKind_ComboBox.getSelectedItem());

            }
        }
//Validation
        if (this.getEntity().getClass() == ComboBoxValue.class) {
            ComboBoxValue<TItemDefinition> comboBoxValue = (ComboBoxValue<TItemDefinition>) this.getEntity();
            if (comboBoxValue.getValue() == null) {
                if (definition.isItemDefinitionExist(itemDefinition)) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            itemDefinition.getId() + " DataType Already Exist !", "Invalid Value",
                            javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        } else if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            if (row[0] == null) {
                if (definition.isItemDefinitionExist(itemDefinition)) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            itemDefinition.getId() + " DataType Already Exist !", "Invalid Value",
                            javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
//set Display Value
        if (this.getEntity().getClass() == ComboBoxValue.class) {
            ComboBoxValue<TItemDefinition> comboBoxValue = (ComboBoxValue<TItemDefinition>) this.getEntity();
            comboBoxValue.setId(itemDefinition.getId());
            comboBoxValue.setValue(itemDefinition);
            comboBoxValue.setDisplayValue(itemDefinition.getId());
        } else if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            row[0] = itemDefinition;
            row[1] = itemDefinition.getStructureRef();
            row[2] = itemDefinition.isIsCollection();
            row[3] = itemDefinition.getItemKind();
        }

        saveActionPerformed(evt);

    }//GEN-LAST:event_save_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        cancelActionPerformed(evt);
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    private void browse_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browse_ButtonActionPerformed
        dataType_TextField.setText(NBModelerUtil.browseClass(modelerFile));
    }//GEN-LAST:event_browse_ButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane actionType_LayeredPane;
    private javax.swing.JButton browse_Button;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JLabel dataType_Label;
    private javax.swing.JLayeredPane dataType_LayeredPane;
    private javax.swing.JTextField dataType_TextField;
    private javax.swing.JCheckBox isCollection_CheckBox;
    private javax.swing.JLabel isCollection_Label;
    private javax.swing.JLayeredPane isCollection_LayeredPane;
    private javax.swing.JComboBox itemKind_ComboBox;
    private javax.swing.JLabel itemKind_Label;
    private javax.swing.JLayeredPane itemKind_LayeredPane;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton save_Button;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
