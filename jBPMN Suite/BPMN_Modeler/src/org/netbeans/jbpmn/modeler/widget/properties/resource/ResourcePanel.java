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
package org.netbeans.jbpmn.modeler.widget.properties.resource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.netbeans.modeler.properties.nentity.Column;
import org.netbeans.modeler.properties.nentity.NAttributeEntity;
import org.netbeans.modeler.properties.nentity.NEntityDataListener;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.ComboBoxValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.Entity;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.client.entity.RowValue;
import org.netbeans.modeler.properties.entity.custom.editor.combobox.internal.EntityComponent;
import org.netbeans.jbpmn.spec.TDefinitions;
import org.netbeans.jbpmn.spec.TItemDefinition;
import org.netbeans.jbpmn.spec.TResource;
import org.netbeans.modeler.core.NBModelerUtil;
import org.netbeans.modeler.core.ModelerFile;
import org.netbeans.modeler.properties.nentity.NEntityEditor;

public class ResourcePanel extends EntityComponent<TResource> {

//    private ComboBoxValue<TResource> comboBoxValue;
    private ModelerFile modelerFile;
    private TDefinitions definition;
    NAttributeEntity attributeEntity;
    TResource resource;

    /**
     * Creates new form CreateMessagePanel
     */
    public ResourcePanel(ModelerFile modelerFile) {
        super("", true);
        this.modelerFile = modelerFile;
        definition = (TDefinitions) modelerFile.getDefinitionElement();
        initComponents();
    }

    @Override
    public void init() {
        initCustomNAttributeEditor();
    }

    @Override
    public void createEntity(Class<? extends Entity> entityWrapperType) {
        this.setTitle("Create new Resource");
        if (entityWrapperType == ComboBoxValue.class) {
            this.setEntity(new ComboBoxValue<TResource>());
        } else if (entityWrapperType == RowValue.class) {
            this.setEntity(new RowValue(new Object[3]));
        }
        name_TextField.setText("");
        attributeEntity = getResourceParameterEntity(null);

        customNAttributeClientEditor1.setAttributeEntity(attributeEntity);

    }

    @Override
    public void updateEntity(Entity<TResource> entityValue) {
        this.setTitle("Update Resource");
        this.setEntity(entityValue);
        TResource resource = null;
        if (entityValue.getClass() == ComboBoxValue.class) {
            this.setEntity(entityValue);
            resource = ((ComboBoxValue<TResource>) entityValue).getValue();
        } else if (entityValue.getClass() == RowValue.class) {
            Object[] row = ((RowValue) entityValue).getRow();
            resource = (TResource) row[0];
        }
        name_TextField.setText(resource.getName() == null ? "" : resource.getName());
        attributeEntity = getResourceParameterEntity(resource);

        customNAttributeClientEditor1.setAttributeEntity(attributeEntity);

    }

    void initCustomNAttributeEditor() {
        parameter_LayeredPane.remove(customNAttributeClientEditor1);
        customNAttributeClientEditor1 = new org.netbeans.modeler.properties.nentity.NEntityEditor();
        parameter_LayeredPane.add(customNAttributeClientEditor1);
        customNAttributeClientEditor1.setBounds(80, 0, 590, 300);
//        pack();
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
        name_LayeredPane = new javax.swing.JLayeredPane();
        name_Label = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        parameter_LayeredPane = new javax.swing.JLayeredPane();
        parameter_Label = new javax.swing.JLabel();
        customNAttributeClientEditor1 = new NEntityEditor();
        action_LayeredPane = new javax.swing.JLayeredPane();
        save_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.openide.awt.Mnemonics.setLocalizedText(name_Label, org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.name_Label.text")); // NOI18N
        name_LayeredPane.add(name_Label);
        name_Label.setBounds(0, 0, 90, 14);

        name_TextField.setText(org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.name_TextField.text")); // NOI18N
        name_TextField.setToolTipText(org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.name_TextField.toolTipText")); // NOI18N
        name_LayeredPane.add(name_TextField);
        name_TextField.setBounds(80, 0, 260, 20);

        jLayeredPane1.add(name_LayeredPane);
        name_LayeredPane.setBounds(20, 20, 340, 30);

        org.openide.awt.Mnemonics.setLocalizedText(parameter_Label, org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.parameter_Label.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, new javax.swing.JTextField(), org.jdesktop.beansbinding.ObjectProperty.create(), parameter_Label, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        parameter_LayeredPane.add(parameter_Label);
        parameter_Label.setBounds(0, 0, 90, 14);
        parameter_LayeredPane.add(customNAttributeClientEditor1);
        customNAttributeClientEditor1.setBounds(80, 0, 590, 300);

        jLayeredPane1.add(parameter_LayeredPane);
        parameter_LayeredPane.setBounds(20, 50, 700, 310);

        org.openide.awt.Mnemonics.setLocalizedText(save_Button, org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.save_Button.text")); // NOI18N
        save_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.save_Button.toolTipText")); // NOI18N
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });
        action_LayeredPane.add(save_Button);
        save_Button.setBounds(30, 0, 57, 23);

        org.openide.awt.Mnemonics.setLocalizedText(cancel_Button, org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.cancel_Button.text")); // NOI18N
        cancel_Button.setToolTipText(org.openide.util.NbBundle.getMessage(ResourcePanel.class, "ResourcePanel.cancel_Button.toolTipText")); // NOI18N
        cancel_Button.setPreferredSize(new java.awt.Dimension(60, 23));
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });
        action_LayeredPane.add(cancel_Button);
        cancel_Button.setBounds(90, 0, 70, 23);

        jLayeredPane1.add(action_LayeredPane);
        action_LayeredPane.setBounds(510, 350, 170, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
NAttributeEntity getResourceParameterEntity(final TResource resource) {
        final NAttributeEntity attributeEntity = new NAttributeEntity("TResourceParameter", "Resource Parameter Mapping", "Resource Parameter Mapping Desc");
        attributeEntity.setCountDisplay(new String[]{"No Resource Parameters set", "One Resource Parameter set", "Resource Parameters set"});

        List<Column> columns = new ArrayList<Column>();

        columns.add(new Column("OBJECT", false, true, Object.class));
        columns.add(new Column("Name", false, String.class));
        columns.add(new Column("Data Type", false, String.class));
        columns.add(new Column("Is Required", false, Boolean.class));
        attributeEntity.setColumns(columns);
        attributeEntity.setCustomDialog(new ResourceParameterPanel(modelerFile));//TODO : MAINTAIN EntityComponent row to entity converter
        attributeEntity.setTableDataListener(new NEntityDataListener() {
            List<Object[]> data = new LinkedList<Object[]>();
            int count;

            @Override
            public void initCount() {
                if (resource != null && resource.getResourceParameter() != null) {
                    count = resource.getResourceParameter().size();
                } else {
                    count = 0;
                }
            }

            @Override
            public int getCount() {
                return count;
            }

            @Override
            public void initData() {
                List<Object[]> data_local = new LinkedList<Object[]>();
                if (resource != null && resource.getResourceParameter() != null) {
                    for (org.netbeans.jbpmn.spec.TResourceParameter resourceParameter : resource.getResourceParameter()) {
                        Object[] row = new Object[4];
                        row[0] = resourceParameter;
                        row[1] = resourceParameter.getName();
                        TItemDefinition itemDefinition = (TItemDefinition) definition.getRootElement(resourceParameter.getType(), TItemDefinition.class);
                        if (itemDefinition == null) {
                            row[2] = null;
                        } else {
                            row[2] = itemDefinition.getDisplayValue();
                        }
                        row[3] = resourceParameter.isIsRequired();
                        data_local.add(row);
                    }
                }
                this.data = data_local;
            }

            @Override
            public List<Object[]> getData() {
                return data;
            }

            @Override
            public void setData(List<Object[]> data) {
                if (ResourcePanel.this.resource.getResourceParameter() != null) {
                    ResourcePanel.this.resource.getResourceParameter().clear();
                }
                for (Object[] row : data) {
                    org.netbeans.jbpmn.spec.TResourceParameter resourceParameter = (org.netbeans.jbpmn.spec.TResourceParameter) row[0];
                    ResourcePanel.this.resource.getResourceParameter().add(resourceParameter);
                }
                initData();
            }
        });
        return attributeEntity;
    }

    private boolean validateField() {
        if (this.name_TextField.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Parameter name can't be empty", "Invalid Value", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }//I18n
        return true;
    }

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        if (!validateField()) {
            return;
        }
//           TResource resource = null;
        if (this.getEntity().getClass() == ComboBoxValue.class) {
            ComboBoxValue<TResource> comboBoxValue = (ComboBoxValue<TResource>) this.getEntity();
            if (comboBoxValue.getValue() == null) {
                resource = new TResource();
                resource.setId(NBModelerUtil.getAutoGeneratedStringId());
            } else {
                resource = comboBoxValue.getValue();
            }

        } else if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            if (row[0] == null) {
                resource = new TResource();
                resource.setId(NBModelerUtil.getAutoGeneratedStringId());
            } else {
                resource = (TResource) row[0];
            }
        }

        resource.setName(name_TextField.getText());
        attributeEntity.getTableDataListener().setData(customNAttributeClientEditor1.getSavedModel());

//        if (comboBoxValue.getValue() == null) {
//            definition.addRootElement(resource);
//        }
        if (this.getEntity().getClass() == ComboBoxValue.class) {
            ComboBoxValue<TResource> comboBoxValue = (ComboBoxValue<TResource>) this.getEntity();
            comboBoxValue.setId(resource.getId());
            comboBoxValue.setValue(resource);
            comboBoxValue.setDisplayValue(resource.getName());
        } else if (this.getEntity().getClass() == RowValue.class) {
            Object[] row = ((RowValue) this.getEntity()).getRow();
            row[0] = resource;
            row[1] = resource.getName();
            String paramCountText = "";
            int paramCount = resource.getResourceParameter().size();
            if (paramCount == 0) {
                paramCountText = "No Parameters exist";
            } else if (paramCount == 1) {
                paramCountText = "One Parameter exist";
            } else if (paramCount > 1) {
                paramCountText = paramCount + " Parameters exist";
            }

            row[2] = paramCountText;

        }
        saveActionPerformed(evt);
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        cancelActionPerformed(evt);
    }//GEN-LAST:event_cancel_ButtonActionPerformed
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ErrorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ErrorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ErrorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ErrorPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ErrorPanel dialog = new ErrorPanel(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane action_LayeredPane;
    private javax.swing.JButton cancel_Button;
    private NEntityEditor customNAttributeClientEditor1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel name_Label;
    private javax.swing.JLayeredPane name_LayeredPane;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JLabel parameter_Label;
    private javax.swing.JLayeredPane parameter_LayeredPane;
    private javax.swing.JButton save_Button;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
