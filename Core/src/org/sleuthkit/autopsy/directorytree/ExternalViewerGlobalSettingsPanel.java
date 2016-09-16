/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package org.sleuthkit.autopsy.directorytree;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.coreutils.Logger;

/**
 * An options panel for the user to create, edit, and delete associations for
 * opening files in external viewers. Users can associate a file by either MIME
 * type or by extension to an executable file.
 */
public class ExternalViewerGlobalSettingsPanel extends javax.swing.JPanel implements OptionsPanel {

    private static final Logger logger = Logger.getLogger(ExternalViewerGlobalSettingsPanel.class.getName());
    private DefaultListModel<ExternalViewerRule> rulesListModel;
    private java.util.List<ExternalViewerRule> rules;

    /**
     * Creates new form ExternalViewerGlobalSettingsPanel
     */
    public ExternalViewerGlobalSettingsPanel() {
        initComponents();
        customizeComponents();
    }

    /**
     * Initializes field variables. Adds a listener to the list of rules.
     */
    private void customizeComponents() {
        rulesListModel = new DefaultListModel<>();
        rules = new ArrayList<>();
        rulesList.setModel(rulesListModel);
        rulesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    if (rulesList.getSelectedIndex() == -1) {
                        clearExePath();
                    } else {
                        populateExePath();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        externalViewerTitleLabel = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        exePanel = new javax.swing.JPanel();
        exePathLabel = new javax.swing.JLabel();
        exePathNameLabel = new javax.swing.JLabel();
        rulesPanel = new javax.swing.JPanel();
        ruleListLabel = new javax.swing.JLabel();
        rulesScrollPane = new javax.swing.JScrollPane();
        rulesList = new javax.swing.JList<>();
        newRuleButton = new javax.swing.JButton();
        editRuleButton = new javax.swing.JButton();
        deleteRuleButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 500));

        org.openide.awt.Mnemonics.setLocalizedText(externalViewerTitleLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.externalViewerTitleLabel.text")); // NOI18N

        jSplitPane1.setDividerLocation(350);
        jSplitPane1.setDividerSize(1);

        org.openide.awt.Mnemonics.setLocalizedText(exePathLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.exePathLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(exePathNameLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.exePathNameLabel.text")); // NOI18N

        javax.swing.GroupLayout exePanelLayout = new javax.swing.GroupLayout(exePanel);
        exePanel.setLayout(exePanelLayout);
        exePanelLayout.setHorizontalGroup(
            exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exePathLabel)
                    .addComponent(exePathNameLabel))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        exePanelLayout.setVerticalGroup(
            exePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exePathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exePathNameLabel)
                .addContainerGap(411, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(exePanel);

        org.openide.awt.Mnemonics.setLocalizedText(ruleListLabel, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.ruleListLabel.text")); // NOI18N

        rulesScrollPane.setViewportView(rulesList);

        newRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/add16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(newRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.newRuleButton.text")); // NOI18N
        newRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRuleButtonActionPerformed(evt);
            }
        });

        editRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/edit16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.editRuleButton.text")); // NOI18N
        editRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRuleButtonActionPerformed(evt);
            }
        });

        deleteRuleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/delete16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteRuleButton, org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.deleteRuleButton.text")); // NOI18N
        deleteRuleButton.setToolTipText(org.openide.util.NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.deleteRuleButton.toolTipText")); // NOI18N
        deleteRuleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRuleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rulesPanelLayout = new javax.swing.GroupLayout(rulesPanel);
        rulesPanel.setLayout(rulesPanelLayout);
        rulesPanelLayout.setHorizontalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rulesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ruleListLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rulesPanelLayout.createSequentialGroup()
                        .addGroup(rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rulesScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rulesPanelLayout.createSequentialGroup()
                                .addComponent(newRuleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editRuleButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteRuleButton)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rulesPanelLayout.setVerticalGroup(
            rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rulesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ruleListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRuleButton)
                    .addComponent(editRuleButton)
                    .addComponent(deleteRuleButton))
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(rulesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane1)
                    .addComponent(externalViewerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(externalViewerTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRuleButtonActionPerformed
        AddRuleDialog dialog = new AddRuleDialog();
        AddRuleDialog.BUTTON_PRESSED result = dialog.getResult();
        if (result == AddRuleDialog.BUTTON_PRESSED.OK) {
            ExternalViewerRule newRule = dialog.getRule();
            // Only allow one association for each MIME type or extension.
            if (rules.contains(newRule)) {
                JOptionPane.showMessageDialog(null,
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.message"),
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.title"),
                        JOptionPane.ERROR_MESSAGE);
            } else {
                rules.add(dialog.getRule());
                updateRulesListModel();
                firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
            }
        }
    }//GEN-LAST:event_newRuleButtonActionPerformed

    private void editRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRuleButtonActionPerformed
        int selected = rulesList.getSelectedIndex();
        AddRuleDialog dialog = new AddRuleDialog(rulesListModel.get(rulesList.getSelectedIndex()));
        AddRuleDialog.BUTTON_PRESSED result = dialog.getResult();
        if (result == AddRuleDialog.BUTTON_PRESSED.OK) {
            rules.remove(selected);
            ExternalViewerRule newRule = dialog.getRule();
            // Only allow one association for each MIME type or extension.
            if (rules.contains(newRule)) {
                JOptionPane.showMessageDialog(null,
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.message"),
                        NbBundle.getMessage(ExternalViewerGlobalSettingsPanel.class, "ExternalViewerGlobalSettingsPanel.JOptionPane.ruleAlreadyExists.title"),
                        JOptionPane.ERROR_MESSAGE);
            } else {
                rules.add(selected, dialog.getRule());
                updateRulesListModel();
                firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
            }
        }
    }//GEN-LAST:event_editRuleButtonActionPerformed

    private void deleteRuleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRuleButtonActionPerformed
        ExternalViewerRule rule = rulesList.getSelectedValue();
        rules.remove(rule);
        updateRulesListModel();
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_deleteRuleButtonActionPerformed

    @Override
    public void store() {
        ExternalViewerRulesManager.getInstance().setUserRules(rules);
    }

    @Override
    public void load() {
        rules = ExternalViewerRulesManager.getInstance().getUserRules();
        updateRulesListModel();
        if (!rulesListModel.isEmpty()) {
            rulesList.setSelectedIndex(0);
        }
        enableButtons();
    }

    /**
     * Enable edit and delete buttons if there is a rule selected.
     */
    private void enableButtons() {
        boolean ruleIsSelected = rulesList.getSelectedIndex() != -1;
        editRuleButton.setEnabled(ruleIsSelected);
        deleteRuleButton.setEnabled(ruleIsSelected);
    }

    /**
     * Sets the list model for the rules list component, sorted by the MIME
     * type or extension alphabetically.
     */
    private void updateRulesListModel() {
        rulesListModel.clear();
        Collections.sort(rules, (ExternalViewerRule rule1, ExternalViewerRule rule2) -> {
            return rule1.getName().compareTo(rule2.getName());
        });
        for (ExternalViewerRule rule : rules) {
            rulesListModel.addElement(rule);
        }
        if (!rulesListModel.isEmpty()) {
            rulesList.setSelectedIndex(0);
        }
    }

    /**
     * Fills in the .exe file path label if a rule is selected.
     */
    private void populateExePath() {
        ExternalViewerRule rule = rulesList.getSelectedValue();
        if (rule != null) {
            exePathNameLabel.setText(rule.getExePath());
        }
        enableButtons();
    }

    /**
     * Clears the .exe file path label.
     */
    private void clearExePath() {
        rulesList.clearSelection();
        exePathNameLabel.setText("");
        enableButtons();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteRuleButton;
    private javax.swing.JButton editRuleButton;
    private javax.swing.JPanel exePanel;
    private javax.swing.JLabel exePathLabel;
    private javax.swing.JLabel exePathNameLabel;
    private javax.swing.JLabel externalViewerTitleLabel;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton newRuleButton;
    private javax.swing.JLabel ruleListLabel;
    private javax.swing.JList<ExternalViewerRule> rulesList;
    private javax.swing.JPanel rulesPanel;
    private javax.swing.JScrollPane rulesScrollPane;
    // End of variables declaration//GEN-END:variables
}
