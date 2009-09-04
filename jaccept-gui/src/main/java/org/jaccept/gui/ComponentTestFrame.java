package org.jaccept.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import org.jaccept.TestEventListener;
import org.jaccept.TestEventManager;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;


public class ComponentTestFrame extends javax.swing.JFrame {
//    private final Logger log = Logger.getLogger(ComponentTestFrame.class);
    private static ComponentTestFrame aInstance;

    /** Creates new form ComponentTestHMI */
    public ComponentTestFrame() {
        initComponents();
        setVisible(true);
        TestEventManager.addTestListener(new TestListener());
        aInstance = this;
        pack();
        setVisible(true);
    }
    
    private void createStimuliSelector() {
    	
    }

    private void initComponents() {
        aResultDescriptionList = new javax.swing.JList();
        aResultDescriptionList.setBorder(new javax.swing.border.EtchedBorder());
//        aResultDescriptionList.setModel(new ResultDescriptionListModel());
        aResultDescriptionList.setCellRenderer(new DisappearingListRenderer());
        aResultDescriptionList.setFixedCellHeight(15);
        aResultDescriptionList.setToolTipText("List of expected results");
        aVerificationRejectButton = new javax.swing.JButton();
        aVerificationRejectButton.setText("Reject");
        aVerificationRejectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                TestEventManager.fail("Result manually rejected");
            }
        });
        aVerificationRejectButton.setToolTipText("Rejcts the test result thereby faling the test. (Not implemented)");
        aVerificationRejectButton.setEnabled(false);
        
        aResultPanelClearButton.setText("Clear");
        aResultPanelClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea2.setText("");
            }
        });
        aResultPanelClearButton.setToolTipText("Clears the result panel");
        aVerificationLeftButtonPanel.add(aResultPanelClearButton);
        aVerificationLeftButtonPanel.add(aWordWrapButton);
        aVerificationAcceptButton = new javax.swing.JButton();
        aVerificationAcceptButton.setText("Accept");
        aVerificationAcceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aAcceptButtonMouseClicked();
            }
        });
        aVerificationAcceptButton.setToolTipText("Accepts the teststep");
        aVerificationButtonPanel.setLayout(new java.awt.BorderLayout());
        aVerificationButtonPanel.add(aVerificationLeftButtonPanel, java.awt.BorderLayout.WEST);
        aVerificationButtonPanel.add(aVerificationRightButtonPanel, java.awt.BorderLayout.EAST);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        aIOPane = new javax.swing.JSplitPane();
        StimuliPanel = new javax.swing.JPanel();
        aStimuliFixedPart = new javax.swing.JPanel();
        StimiliLabel = new javax.swing.JLabel();
        aSettings = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        aLabelPanel = new javax.swing.JPanel();
        aInputModeLabel = new javax.swing.JLabel();
        aInputSpeedLabel = new javax.swing.JLabel();
        aSelectorPanel = new javax.swing.JPanel();
        aModeSelector = new javax.swing.JComboBox();
        
        aModeSelector.setToolTipText("Select stimuli mode");
        aSpeedSelector = new javax.swing.JComboBox();
        aSpeedSelector.setToolTipText("<html>Select the speed the stimuli should be applied (Not implemented)</html>");
        aStimuliDescriptionList = new javax.swing.JList();
        stimuliListModel = new DefaultListModel();
        stimuliList = new JList(stimuliListModel);
        jTextAreaScroolPane1 = new JScrollPane(stimuliList);
        aVerificationPanel = new javax.swing.JPanel();
        aVerificationFixedPart = new javax.swing.JPanel();
        aVerificationSettingPane = new javax.swing.JPanel();
        aVerificationModePane = new javax.swing.JPanel();
        aInputModeLabel1 = new javax.swing.JLabel();
        aModeSelector2 = new javax.swing.JComboBox();
        aModeSelector2.setEnabled(false);
        aModeSelector2.setToolTipText("<html>Select the verification mode (Not implemented)</html>");
        aAcceptPane = new javax.swing.JPanel();
        aVerificationLabel = new javax.swing.JLabel();
        jTextArea2 = new javax.swing.JTextArea();
        jTextAreaScroolPane2 = new JScrollPane(jTextArea2);
        jMenuBar1 = new javax.swing.JMenuBar();
        aFileMenu = new javax.swing.JMenu();
        aOpenTestSetItem = new javax.swing.JMenuItem();
        aOptionMenu = new javax.swing.JMenu();
        aGenerateReportSelection = new javax.swing.JCheckBoxMenuItem();
        aToolMenu = new javax.swing.JMenu();
        aGenerateSpecificationItem = new javax.swing.JMenuItem();

        setTitle("Component Test");
        setName("Component Test HMI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(new javax.swing.border.TitledBorder(""));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setPreferredSize(new java.awt.Dimension(50, 16));
        jPanel1.add(jLabel2, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        aIOPane.setDividerSize(2);
        aIOPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        aIOPane.setResizeWeight(0.5);
        aIOPane.setPreferredSize(new java.awt.Dimension(1000, 500));
        StimuliPanel.setLayout(new java.awt.BorderLayout());

        StimuliPanel.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        aStimuliFixedPart.setLayout(new java.awt.BorderLayout());

        StimiliLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StimiliLabel.setText("Stimuli");
        aStimuliFixedPart.add(StimiliLabel, java.awt.BorderLayout.NORTH);

        aSettings.setLayout(new java.awt.BorderLayout());

        aSettings.setMaximumSize(new java.awt.Dimension(100, 50));
        aSettings.setMinimumSize(new java.awt.Dimension(10, 50));
        aSettings.setPreferredSize(new java.awt.Dimension(140, 65));
        jPanel2.setLayout(new java.awt.BorderLayout());

        aLabelPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        aInputModeLabel.setText("Mode  ");
        aLabelPanel.add(aInputModeLabel);

        aInputSpeedLabel.setText("Step wait ");
        aLabelPanel.add(aInputSpeedLabel);

        jPanel2.add(aLabelPanel, java.awt.BorderLayout.WEST);

        aSelectorPanel.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        aSelectorPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)));
        aModeSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auto", "Manual" }));
        aModeSelector.setSelectedItem("Manual");
        TestEventManager.getInstance().getTestState().setBlocking(true);
        aSelectorPanel.add(aModeSelector);

        aSpeedSelector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "2 seconds", "5 seconds", "10 seconds" }));
        aSelectorPanel.add(aSpeedSelector);

        jPanel2.add(aSelectorPanel, java.awt.BorderLayout.CENTER);

        aSettings.add(jPanel2, java.awt.BorderLayout.NORTH);

        aStimuliFixedPart.add(aSettings, java.awt.BorderLayout.WEST);

        aStimuliDescriptionList.setModel(new StimuliDescriptionListModel());
        aStimuliDescriptionList.setCellRenderer(new DisappearingListRenderer());
        aStimuliDescriptionList.setFixedCellHeight(15);

        aStimuliFixedPart.add(aStimuliDescriptionList, java.awt.BorderLayout.CENTER);
        StimuliPanel.add(aStimuliFixedPart, java.awt.BorderLayout.NORTH);

//        stimuliList.setLineWrap(true);
        jTextAreaScroolPane1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jTextAreaScroolPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextAreaScroolPane1.setAutoscrolls(true);
        StimuliPanel.add(jTextAreaScroolPane1, java.awt.BorderLayout.CENTER);
        aIOPane.setTopComponent(StimuliPanel);

        aVerificationPanel.setLayout(new java.awt.BorderLayout());

        aVerificationFixedPart.setLayout(new java.awt.BorderLayout());

        aVerificationFixedPart.setBorder(new javax.swing.border.MatteBorder(null));
        aVerificationSettingPane.setLayout(new java.awt.BorderLayout(0, 5));

        aVerificationSettingPane.setMaximumSize(new java.awt.Dimension(100, 50));
        aVerificationSettingPane.setMinimumSize(new java.awt.Dimension(10, 50));
        aVerificationSettingPane.setPreferredSize(new java.awt.Dimension(160, 60));
        aVerificationModePane.setLayout(new java.awt.BorderLayout(5, 0));

        aVerificationModePane.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(5, 5, 5, 5)));
        aInputModeLabel1.setText("Mode    ");
        aVerificationModePane.add(aInputModeLabel1, java.awt.BorderLayout.WEST);
        
        aVerificationModePane.add(aModeSelector2, java.awt.BorderLayout.CENTER);

        aVerificationSettingPane.add(aVerificationModePane, java.awt.BorderLayout.NORTH);

        aAcceptPane.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        aAcceptPane.setPreferredSize(new java.awt.Dimension(168, 26));

        aVerificationSettingPane.add(aAcceptPane, java.awt.BorderLayout.SOUTH);

        aVerificationFixedPart.add(aVerificationSettingPane, java.awt.BorderLayout.WEST);

        aVerificationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aVerificationLabel.setText("Verification");
        aVerificationFixedPart.add(aVerificationLabel, java.awt.BorderLayout.NORTH);

        aVerificationFixedPart.add(aResultDescriptionList, java.awt.BorderLayout.CENTER);

        aVerificationPanel.add(aVerificationFixedPart, java.awt.BorderLayout.NORTH);

        jTextArea2.setLineWrap(true);
        jTextAreaScroolPane2.setPreferredSize(new java.awt.Dimension(1000, 500));
        jTextAreaScroolPane2.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        aVerificationPanel.add(jTextAreaScroolPane2, java.awt.BorderLayout.CENTER);
        aVerificationPanel.add(aVerificationButtonPanel, java.awt.BorderLayout.SOUTH);
        aIOPane.setBottomComponent(aVerificationPanel);

        getContentPane().add(aIOPane, java.awt.BorderLayout.CENTER);

        aFileMenu.setText("File");
        aOpenTestSetItem.setText("Open test set");
        aFileMenu.add(aOpenTestSetItem);

        jMenuBar1.add(aFileMenu);

        aOptionMenu.setText("Options");
        aGenerateReportSelection.setText("Generate report");
        aOptionMenu.add(aGenerateReportSelection);

        jMenuBar1.add(aOptionMenu);

        aToolMenu.setText("Tools");
        aGenerateSpecificationItem.setText("Generate specification");
        aToolMenu.add(aGenerateSpecificationItem);

        jMenuBar1.add(aToolMenu);

        setJMenuBar(jMenuBar1);
        setBounds(new java.awt.Rectangle(0,0,846,510));
        pack();
        aVerificationRightButtonPanel.add(aVerificationAcceptButton);
        aVerificationRightButtonPanel.add(aVerificationRejectButton);
        enableManualAccept(false);
        aResultPanelClearButton.setToolTipText("Clear Resultpanel");
        aResultPanelClearButton.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                aResultPanelClearButtonMouseClicked(e);
            }
        });
        aWordWrapButton.setIcon(
                new javax.swing.ImageIcon("picture/wordwrap.gif"));
        aWordWrapButton.setPreferredSize(new java.awt.Dimension(27, 27));
        aWordWrapButton.setSize(new java.awt.Dimension(27, 27));
        aWordWrapButton.setToolTipText("Enable word wrap");
        aWordWrapButton.setSelected(true);
        aWordWrapButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    stimuliList.setLineWrap(true);
                    jTextArea2.setLineWrap(true);
                }
                else  {
//                    stimuliList.setLineWrap(false);
                    jTextArea2.setLineWrap(false);
                }
            }
        });
    }//GEN-END:initComponents

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private synchronized void aAcceptButtonMouseClicked() {
        TestEventManager.unblock();
    }

    public void aResultPanelClearButtonMouseClicked(MouseEvent e) { }

    public void enableManualAccept(boolean enable){
        aVerificationAcceptButton.setEnabled(enable);
        aVerificationRejectButton.setEnabled(enable);
    }

    private class TestListener implements TestEventListener{
        private int aStepCounter = 0;
        private String description;  

        public void projectStarted(String name) {
        }

        public void suiteStarted(String name) {
        }


        public void caseStarted(String name) {
            aStepCounter = 0;
            jLabel1.setText(name);
            JOptionPane.showMessageDialog(aInstance, name+"\n"+description, "Run suite", JOptionPane.PLAIN_MESSAGE);        
        }

        public void testStarted(String name) {  }

        public void stepStarted(String stimuli, String expectedResult) {
            aStepCounter++;
            jLabel2.setText("Step "+aStepCounter);
            stimuliListModel.addElement("\nStep "+aStepCounter+"\n");
            jTextArea2.append("\nStep "+aStepCounter+"\n");
            enableManualAccept(false);
        }

        public void addStimuli(String stimuli) {
            stimuliListModel.addElement(stimuli+"\n");
            stimuliList.ensureIndexIsVisible(stimuliListModel.getSize()-1);
        }

        public void addResult(String result) {
            jTextArea2.append(result+"\n");
        }

        public void addTestSpecific(String awaittype) {
        }

        public void addNotification(String result) {
            jTextArea2.append(result+"\n");
        }

        public void reference(String reference) {
            
        }

        public void description(String description) {
        	this.description = description;
        }
        public void addPurpose(String name) {
        }

        public void addNotPerformed() {
        }

        public void addSetUp(String name) {
            jLabel2.setText("Initialising test");
        }

        public void addTearDown(String tearDownAction) {
            enableManualAccept(false);
            jLabel2.setText("Finishing test");
        }

        public void testError(String message) {
        }

        public void addWarn(String message) {
        }

        public void stepEnded() {
            enableManualAccept(true);
            TestEventManager.getInstance().block();
        }

        public void testEnded() {
            enableManualAccept(true);
        }

        public void testFailed(String message) {
        }

		public void onFinish(ITestContext arg0) {
		}

		public void onStart(ITestContext arg0) {
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		}

		public void onTestFailure(ITestResult arg0) {
		}

		public void onTestSkipped(ITestResult arg0) {
		}

		public void onTestStart(ITestResult arg0) {
            aStepCounter = 0;
            jLabel1.setText(arg0.getName());
            stimuliList.removeAll();
            jTextArea2.removeAll();
            if (TestEventManager.getInstance().getTestState().getBlocking()) JOptionPane.showMessageDialog(aInstance, arg0.getName()+"\n"+description, "Run test", JOptionPane.PLAIN_MESSAGE);
      
		}

		public void onTestSuccess(ITestResult arg0) {
		}

		public void onFinish(ISuite arg0) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ISuite arg0) {
			// TODO Auto-generated method stub
			
		}

		public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,
				String arg2) {
			// TODO Auto-generated method stub
			
		}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StimiliLabel;
    private javax.swing.JPanel StimuliPanel;
    private javax.swing.JPanel aAcceptPane;
    private javax.swing.JMenu aFileMenu;
    private javax.swing.JCheckBoxMenuItem aGenerateReportSelection;
    private javax.swing.JMenuItem aGenerateSpecificationItem;
    private javax.swing.JSplitPane aIOPane;
    private javax.swing.JLabel aInputModeLabel;
    private javax.swing.JLabel aInputModeLabel1;
    private javax.swing.JLabel aInputSpeedLabel;
    private javax.swing.JPanel aLabelPanel;
    private javax.swing.JComboBox aModeSelector;
    private javax.swing.JComboBox aModeSelector2;
    private javax.swing.JMenuItem aOpenTestSetItem;
    private javax.swing.JMenu aOptionMenu;
    private JList aResultDescriptionList;
    private javax.swing.JPanel aSelectorPanel;
    private javax.swing.JPanel aSettings;
    private javax.swing.JComboBox aSpeedSelector;
    private javax.swing.JList aStimuliDescriptionList;
    private javax.swing.JPanel aStimuliFixedPart;
    private javax.swing.JMenu aToolMenu;
    private javax.swing.JPanel aVerificationFixedPart;
    private javax.swing.JLabel aVerificationLabel;
    private javax.swing.JPanel aVerificationModePane;
    private javax.swing.JPanel aVerificationPanel;
    private javax.swing.JPanel aVerificationSettingPane;
    private JButton aVerificationAcceptButton;
    private JButton aVerificationRejectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JScrollPane jTextAreaScroolPane1;
    private javax.swing.JList  stimuliList;
    private DefaultListModel  stimuliListModel;
    private JScrollPane jTextAreaScroolPane2;
    private javax.swing.JTextArea jTextArea2;
    private JPanel aVerificationButtonPanel = new JPanel();
    private JPanel aVerificationLeftButtonPanel = new JPanel();
    private JPanel aVerificationRightButtonPanel = new JPanel();
    private JButton aResultPanelClearButton = new JButton();
    private JToggleButton aWordWrapButton = new JToggleButton();
    // End of variables declaration//GEN-END:variables
}
