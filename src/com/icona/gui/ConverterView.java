/*
 * ConverterView.java
 */

package com.icona.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import jsyntaxpane.DefaultSyntaxKit;

import org.jdesktop.application.Action;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.TaskMonitor;

import com.icona.console.main.ConsoleMain;
import com.icona.helper.SymbolTable;
import com.icona.tree.nodes.ClassInterface;
import com.icona.tree.nodes.PackageDef;
import com.icona.tree.nodes.Protocol;

/**
 * The application's main frame.
 */
public class ConverterView extends FrameView {

    public ConverterView(SingleFrameApplication app) {
        super(app);

        initComponents();
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        
        URL url;
        try{
        	url=ClassLoader.getSystemResource("./com/icona/gui/resources/about.png");
        	Toolkit kit=Toolkit.getDefaultToolkit();
        	Image img=kit.createImage(url);
        	this.getFrame().setIconImage(img);
        }catch(Exception e){
        	System.err.println("Error icon");
        	e.printStackTrace();
        }
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ConverterApp.getApplication().getMainFrame();
            aboutBox = new ConverterAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ConverterApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	status="Ready!";
    	
        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        
        openButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        mapButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        convertButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        saveButton = new javax.swing.JButton();
        appStatus = new javax.swing.JLabel();
        appStatusText = new javax.swing.JTextField();
        
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ConverterApp.class).getContext().getResourceMap(ConverterView.class);
      //  openButton.setBackground(resourceMap.getColor("openButton.background")); // NOI18N
        openButton.setText(resourceMap.getString("openButton.text")); // NOI18N
        openButton.setIcon(resourceMap.getIcon("NewProject"));
        openButton.setFocusable(false);
        //openButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton.setName("openButton"); // NOI18N
        //openButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openButtonMouseClicked(evt);
            }
        });
        jToolBar1.add(openButton);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jToolBar1.add(jSeparator1);

        saveButton.setBackground(resourceMap.getColor("saveButton.background")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setIcon(resourceMap.getIcon("SaveFile"));
        saveButton.setFocusable(false);
       // saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setName("saveButton"); // NOI18N
      //  saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        jToolBar1.add(saveButton);
       
        jSeparator3.setName("jSeparator3"); // NOI18N
        jToolBar1.add(jSeparator3);

       // mapButton.setBackground(resourceMap.getColor("mapButton.background")); // NOI18N
        mapButton.setText(resourceMap.getString("mapButton.text")); // NOI18N
        mapButton.setIcon(resourceMap.getIcon("MapApi"));
        mapButton.setFocusable(false);
        //mapButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mapButton.setName("mapButton"); // NOI18N
        //mapButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapButtonMouseClicked(evt);
            }
        });
        //jToolBar1.add(mapButton);

        jSeparator2.setName("jSeparator2"); // NOI18N
        //jToolBar1.add(jSeparator2);

       // convertButton.setBackground(resourceMap.getColor("convertButton.background")); // NOI18N
       // convertButton.setSize(200, 100);
        convertButton.setText(resourceMap.getString("convertButton.text")); // NOI18N
        convertButton.setIcon(resourceMap.getIcon("Convert")); 
        convertButton.setFocusable(false);
        convertButton.setName("convertButton"); // NOI18N
        convertButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        convertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                convertButtonMouseClicked(evt);
            }
        });
        jToolBar1.add(convertButton);
       
        appStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        appStatus.setBackground(resourceMap.getColor("RecentActivity.background")); // NOI18N
        appStatus.setText("Recent Activity: "); // NOI18N
        appStatus.setMaximumSize(new java.awt.Dimension(800, 14));
        appStatus.setFocusable(false);
       // saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appStatus.setName("AppStatus"); // NOI18N
      
        jToolBar1.add(appStatus);


        //appStatusText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        //appStatusText.setBackground(resourceMap.getColor("saveButton.background")); // NOI18N
        appStatusText.setText("no activity..."); // NOI18N
        appStatusText.setMaximumSize(new java.awt.Dimension(380, 20));
        appStatusText.setFocusable(false);
       // saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appStatusText.setName("AppStatusText"); // NOI18N
      
        jToolBar1.add(appStatusText);
        
        
        projectTabs = new ClosableTabbedPane();
        projectTabs.setName("ProjectTabs"); // NOI18N

        JSplitPane jSplitT=new JSplitPane();
        JSplitPane jSplitP=new JSplitPane();

        jSplitT.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitT.setDividerLocation(300);

        jSplitP.setRightComponent(new JScrollPane());

        jSplitT.setTopComponent(new JScrollPane());
        jSplitT.setBottomComponent(new JScrollPane());

        jSplitT.setMinimumSize(new Dimension(200,50));
        jSplitP.setLeftComponent(jSplitT);

        projectTabs.addTab("Empty Project", resourceMap.getIcon("ProjectTabs"),jSplitP );

        
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(projectTabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N
        
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(ConverterApp.class).getContext().getActionMap(ConverterView.class, this);
        
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        
        // create an Action doing what you want
        AbstractAction saveAction = new AbstractAction("saveAction") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("triggered save shortcut");
                appStatusText.setText("triggered save shortcut");
                ConverterView.this.saveButtonMouseClicked(null);
            }

        };
        
        // configure the Action with the accelerator (aka: short cut)
        saveAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
        saveButton.getActionMap().put("save", saveAction);
        saveButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) saveAction.getValue(AbstractAction.ACCELERATOR_KEY), "save");
        
        
        AbstractAction openAction = new AbstractAction("openAction") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("triggered open shortcut");
                appStatusText.setText("triggered open shortcut");
                ConverterView.this.openButtonMouseClicked(null);
            }

        };
        
        // configure the Action with the accelerator (aka: short cut)
        openAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
        openButton.getActionMap().put("open", openAction);
        openButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) openAction.getValue(AbstractAction.ACCELERATOR_KEY), "open");
   
        
        AbstractAction convertAction = new AbstractAction("convertAction") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("triggered convert shortcut");
                appStatusText.setText("triggered convert shortcut");
                ConverterView.this.convertButtonMouseClicked(null);
            }

        };
        
        // configure the Action with the accelerator (aka: short cut)
        convertAction.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control K"));
        convertButton.getActionMap().put("convert", convertAction);
        convertButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) convertAction.getValue(AbstractAction.ACCELERATOR_KEY), "convert");
     
        
        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N


        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

   // private JSplitPane jSplitT;

    private void openButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    	
    	SymbolTable.forceNull();
    	
        final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ConverterApp.class).getContext().getResourceMap(ConverterView.class);
    	      File dir = null;
              JFileChooser jFile= new JFileChooser () ;
              jFile.setFileSelectionMode(2);  //jFile.setDialogTitle("Open project folder");
   
        if (jFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (projectTabs.getTabCount() > 0) {
                if (projectTabs.getTabTitleAt(0).equals("Empty Project")) {
                    projectTabs.removeAll();
                }
            }
            appStatusText.setText("New project added!");
            dir = jFile.getSelectedFile();
        } else {
            return;
        }

        FileSystemModel modelI = new FileSystemModel(dir);
        final JTree jTI = new JTree(modelI);

        final ClosableTabbedPane jTab = new ClosableTabbedPane();

        JScrollPane jScrollI = new JScrollPane(jTI);

        JSplitPane jSplitT = new JSplitPane();
        JSplitPane jSplitP = new JSplitPane();

        jSplitP.setName(dir.getAbsolutePath());
        
        jSplitT.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitT.setDividerLocation(300);

        jSplitP.setRightComponent(jTab);

        jSplitT.setTopComponent(jScrollI);
        jSplitT.setRightComponent(new JScrollPane(null));

        jSplitP.setLeftComponent(jSplitT);

        jTI.setEditable(true);

        jTI.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent event) {
                File file = (File) jTI.getLastSelectedPathComponent();
                for (int i = 0; i < jTab.getTabCount(); i++) {
                  //  if (jTab.getTabTitleAt(i).equals(file.getName())) {
        			if(jTab.getToolTipTextAt(i).equals(file.getAbsolutePath())){
                        System.out.println("Already open-setting focus");
                        appStatusText.setText("already open...setting active tab");
                        jTab.setSelectedIndex(i);
                        return;
                    }
                }
                selectedFile = file;
                System.out.println("You selected " + file.getPath());
                appStatusText.setText("viewing file...");
                if (file.isFile()) {
               	 	
                	DefaultSyntaxKit.initKit();
            	 
                    JEditorPane jEdit = new JEditorPane();
   
                    jTab.addTab(file.getName()+"   ",resourceMap.getIcon("Tabs.notConverted") , new JScrollPane(jEdit),file.getAbsolutePath());
                    jTab.setSelectedIndex(jTab.getTabCount() - 1);
                    
                //    String fileType = file.getName().substring(file.getName().lastIndexOf('.')+1, file.getName().length());
               //     System.out.println(fileType);
              //      if(fileType.equals("h") || fileType.equals("m") || fileType.equals("mm"))
                    	jEdit.setContentType("text/c");
                    
                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new FileReader(file.getPath()));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ConverterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        jEdit.read(in, "readfile");
                    } catch (IOException ex) {
                        Logger.getLogger(ConverterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        
        projectTabs.addTab(dir.getName()+"  ", resourceMap.getIcon("ProjectTabs"), jSplitP);

        JSplitPane jp = (JSplitPane) projectTabs.getComponent(0);
        System.out.println("***Source*******");
        System.out.println("ParentClass: " + jp.getClass());
        System.out.println(jp.getComponent(0).getClass());
        System.out.println(jp.getComponent(1).getClass());
        System.out.println(jp.getComponent(2).getClass());
        System.out.println("****************");

        projectTabs.setSelectedIndex(projectTabs.getTabCount() - 1);

    }//GEN-LAST:event_jButton1MouseClicked

    private void convertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:

        JSplitPane jp = (JSplitPane) projectTabs.getSelectedComponent();
        
        JSplitPane jSplitP = jp;
       
    	if(jp.getName()==null){
    	        String message = "No project folder was found for conversion. Please open a project folder first.";
    	        JOptionPane pane = new JOptionPane(message);
    	        JDialog dialog = pane.createDialog(new JFrame(), "No Project Open!");
    	        dialog.show();
    	        return;
    	}
    	
        File dest = null;
        JFileChooser jFile = new JFileChooser();
        jFile.setFileSelectionMode(2);

        if (jFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            dest = jFile.getSelectedFile();
        }
        else return;
        

        /* run the conversion routine, convert files in dir object, place the converted in dest */
		
		String filename = null;
		
		File dir = new File(jp.getName());

		
	    /* project folder for conversion goes here */
	   
		
	    try {
	    	ConsoleMain.ConversionObjects.resetFileIndex();
			ConsoleMain.ConversionObjects.createFileIndex(dir,  true);
		
			Collection headerFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("h");
		
			ConsoleMain.ConversionObjects.parseFile(headerFiles, dir);
	
			Collection mFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("m");
			
			ConsoleMain.ConversionObjects.parseFile(mFiles, dir);
			
			Collection mmFiles= (Collection)ConsoleMain.ConversionObjects.fileIndex.get("mm");
			
			ConsoleMain.ConversionObjects.parseFile(mmFiles, dir);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("************Raw Symbol Table**************************************\n");
	//	symbolTable.printRaw();
		System.out.println("************Formulated Symbol Table******************************\n");
	//	symbolTable.printFormulated();
		System.out.println("***************************************************************\n");
	
		 try{
		
		  ArrayList<PackageDef> packages = SymbolTable.getInstance().getPackages();	 
		 
		  Iterator it = packages.iterator();
		  FileWriter fstream = null;
		  String path;
		  while(it.hasNext()){
			  PackageDef package_ = (PackageDef) it.next();
			  path = dest.getPath()+"/src/"+package_.getPackageName().replace(".", "/");
			//  System.out.println(path);
			  
			  boolean pkDir = (new File(path).mkdirs());
			  
			  //			ArrayList<ClassInterface> listClass=package_.getListClass();
			  			Iterator itr = package_.getClassList().getIterator();
			  			while(itr.hasNext()){
			  				ClassInterface c= (ClassInterface) itr.next();
			  				fstream = new FileWriter(path+"/"+(c.getClassName().getName()+".java"));
							  BufferedWriter out = new BufferedWriter(fstream);
							  out.write(c.toString());
							  //Close the output stream
							  out.close();
			  			}
			  			
			  			Iterator protocolItr = package_.getProtocolList().getIterator();
			  			while(protocolItr.hasNext()){
			  			Protocol c= (Protocol) protocolItr.next();
			  			fstream = new FileWriter(path+"/"+(c.getProtocolName().getName()+".java"));
			  			BufferedWriter out = new BufferedWriter(fstream);
			  			out.write(c.toString());
			  			//Close the output stream
			  			out.close();
			  			}

		  }


		  }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
		
	
		/************************************/
		 
		 appStatusText.setText("Project converted successfully!");

        FileSystemModel modelC = new FileSystemModel(dest);

        final JTree jTC = new JTree(modelC);


        System.out.println("***Destination****");
        System.out.println("ParentClass: "+jp.getClass());
        System.out.println(jp.getComponent(1).getClass());
        System.out.println(jp.getComponent(2).getClass());
        System.out.println("******************");

        final ClosableTabbedPane jTab = (ClosableTabbedPane) jp.getComponent(1);
    
        jSplitP.setRightComponent(jTab);

        jTC.setEditable(true);

        JSplitPane jSplitT = (JSplitPane) jp.getComponent(1);

        JScrollPane jScrollC=new JScrollPane(jTC);
        
        jScrollC.setSize(170, GroupLayout.DEFAULT_SIZE);

        jSplitT.setRightComponent(jScrollC);
        
        jSplitT.setDividerLocation(300);
        
        final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ConverterApp.class).getContext().getResourceMap(ConverterView.class);
        
        jTC.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent event) {
                File file = (File) jTC.getLastSelectedPathComponent();
                for (int i = 0; i < jTab.getTabCount(); i++) {
 
                //	jTab.getToolTipTextAt(i));
                    //if (jTab.getTabTitleAt(i).equals(file.getName())) {
        			if(jTab.getToolTipTextAt(i).equals(file.getAbsolutePath())){
                        System.out.println("Already open-setting focus");
                        appStatusText.setText("already open...setting active tab");
                        jTab.setSelectedIndex(i);
                        return;
                    }
                }
                
                selectedFile = file;
                System.out.println("You selected " + file.getPath());
                appStatusText.setText("viewing file...");
                if (file.isFile()) {

                	 DefaultSyntaxKit.initKit();
                	 
                    JEditorPane jEdit = new JEditorPane();
                    jTab.addTab(file.getName()+ "   ",resourceMap.getIcon("Tabs.converted") , new JScrollPane(jEdit),file.getAbsolutePath());
                    //jTab.addTab(file.getName(), new JScrollPane(jEdit));
                    jTab.setSelectedIndex(jTab.getTabCount() - 1);
                //    String fileType = file.getName().substring(file.getName().lastIndexOf('.')+1, file.getName().length());
                 //   System.out.println(fileType);
                  //  if(fileType.equals("java"))
                    	jEdit.setContentType("text/java");
                    
                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new FileReader(file.getPath()));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ConverterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        jEdit.read(in, "readfile");
                    } catch (IOException ex) {
                        Logger.getLogger(ConverterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }//GEN-LAST:event_jButton3MouseClicked

    
    private void mapButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //ApiMapView ap = new ApiMapView((SingleFrameApplication) this.getApplication());
    	FrameView ap = new FrameView(this.getApplication());
    	//ApiMap ap = new ApiMap();
    	ap.setComponent(new ApiMap());
        this.getApplication().show(ap);

    }//GEN-LAST:event_jButton2MouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    		//projectTabs.getSelectedComponent();
    		//JSplitPane splitPaneMain = (JSplitPane) projectTabs.getComponent(0);
    		JSplitPane splitPaneMain = (JSplitPane) projectTabs.getSelectedComponent();
    		
    		//System.out.println(splitPaneMain.getComponent(1).getClass().getName());
    		//System.out.println(splitPaneMain.getRightComponent().getClass().getName());
			ClosableTabbedPane fileTabs = (ClosableTabbedPane) splitPaneMain.getRightComponent();//splitPaneMain.getComponent(1);

			if (fileTabs.getSelectedComponent() != null) {
				JScrollPane jp1 = (JScrollPane) fileTabs.getSelectedComponent();
				JViewport jv1 = (JViewport) jp1.getComponent(0);
				JEditorPane fileContent = (JEditorPane) jv1.getComponent(0);

				try {
					System.out.println("Saving at: "+ fileTabs.getToolTipTextAt(fileTabs.getSelectedIndex()));

					//FileWriter out = new FileWriter(selectedFile.getAbsolutePath());
					FileWriter out = new FileWriter(fileTabs.getToolTipTextAt(fileTabs.getSelectedIndex()));
					appStatusText.setText("File saved!");
					System.out.println("Saved at: "+ fileTabs.getToolTipTextAt(fileTabs.getSelectedIndex()));
					out.write(fileContent.getText());
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
  
    }//GEN-LAST:event_jButton3MouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JLabel appStatus;
    private javax.swing.JTextField appStatusText;
    private javax.swing.JButton openButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JButton mapButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private File selectedFile;
    private ClosableTabbedPane projectTabs;
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    String status;

    private JDialog aboutBox;

}
