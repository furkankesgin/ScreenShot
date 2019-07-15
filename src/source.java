import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class source extends JFrame implements ActionListener, NativeKeyListener {
    source(){
        super("ScreenShot");
        this.setLayout(null);
        menu();
        color();
        locations();
        visible();
        add();
        listener();
        fonts();
        focusfalse();
        //takecoordinates();
        //addKeyListener(this);
        Native();
        //JLabel pictrue =  new JLabel();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(("icon.png"))));


    }

    void images(){

    }


    ///////////////////////Framedeki herseyin ayarlanmak istenen rengini ayarliyoruz.
    void color(){
        if (System.getProperty("os.name").contains("win")) {
            photo.setForeground(new Color(255, 255, 255, 255));
            photo.setBackground(new Color(0, 0, 0, 100));
            kayit.setForeground(new Color(255, 255, 255, 255));
            kayit.setBackground(new Color(0, 0, 0, 100));
        }
        labelmenuexit.setBackground(new Color(0,0,0,255));
        radioButtonFullScreen.setForeground(new Color(255,255,255,255));
        radioButtonFullScreen.setBackground(new Color(255,255,255,0));
        radioButtonManualScreen.setForeground(new Color(255,255,255,255));
        radioButtonManualScreen.setBackground(new Color(255,255,255,0));
        labelshooted.setForeground(Color.GREEN);
        lock.setBackground(new Color(255,255,255,0));
        lock.setForeground(new Color(255,255,255,255));



    }

    //////////////////////////////Focus olmasi bazen keylistenerda sorun cikairttigi icin bizde hepsini unfocusable yapiyoruz.
    void focusfalse(){
        radioButtonFullScreen.setFocusable(false);
        radioButtonManualScreen.setFocusable(false);
        kayit.setFocusable(false);
        photo.setFocusable(false);
        button.setFocusable(false);
        lock.setFocusable(false);
        labelshooted.setFocusable(false);
        labelmenuexit.setFocusable(false);
        labelmenuminimize.setFocusable(false);
        labelmenuhelp.setFocusable(false);
    }


    //////////////////////////Yazi fontunu ve rengini ayarliyoruz
    void fonts(){
        radioButtonFullScreen.setFont(new Font("Courier New", Font.ROMAN_BASELINE, 12));
        radioButtonManualScreen.setFont(new Font("Courier New", Font.ROMAN_BASELINE, 12));
        lock.setFont(new Font("Courier New", Font.ROMAN_BASELINE, 12));
        labelshooted.setFont(new Font("Courier New", Font.BOLD, 18));
    }

    ///////////////////////////componentleri nereye yerlestiricegimizi belirliyoruz
    void locations(){
        labelmenuexit.setBounds(275, 10, 20, 20);
        labelmenuminimize.setBounds(250, 10, 20, 20);
        labelmenuhelp.setBounds(225, 10, 20, 20);
        photo.setBounds(15,30,100,30);
        button.setBounds(230, 40, 50, 50);
        radioButtonFullScreen.setBounds(120,30,120,20);
        radioButtonManualScreen.setBounds(120,55,120,20);
        kayit.setBounds(15,60,100,30);
        labelshooted.setBounds(100,100, 250,30);
        lock.setBounds(120,75,120,20);

    }


    //////////////////componentler gosteriyoruz.
    void visible(){
        labelmenuexit.setVisible(true);
        labelmenuhelp.setVisible(true);
        labelmenuminimize.setVisible(true);
        photo.setVisible(true);
        kayit.setVisible(true);
    }


    ///////////////////////framee objelerimizi yerlestiriyoruz.
    void add(){
        add(labelmenuexit);
        add(labelmenuminimize);
        add(labelmenuhelp);
        add(photo);
        add(button);
        add(radioButtonFullScreen);
        add(radioButtonManualScreen);
        group.add(radioButtonManualScreen);
        group.add(radioButtonFullScreen);
        add(kayit);
        add(labelshooted);
        //this.addKeyListener(this);
        add(lock);

    }


    void listener(){
        button.addActionListener(this);

    }

/////////////////////////////////////MENU BASLANGIC//////////////////////////////////////////////////////////////
    void menu(){

      //  labelmenuexit.setIcon(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
       // labelmenuminimize.setIcon(new ImageIcon(new ImageIcon("images/minimize.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
       // labelmenuhelp.setIcon(new ImageIcon(new ImageIcon("images/help.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
       // button.setIcon(new ImageIcon(new ImageIcon("images/camera.png").getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT)));


        ImageIcon img2 = new ImageIcon("images/icon.png");
        this.setIconImage(img2.getImage());

        //Butonlarin ustundeki uzerine gelince yazan sey
        labelmenuminimize.setToolTipText("Minimize");
        labelmenuhelp.setToolTipText("Help");
        labelmenuexit.setToolTipText("Close");

        ////////////////////labellera eventlistner ekliyoruz/////////////////////////////////////////
        labelmenuexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
                super.mouseClicked(e);
            }
        });


        labelmenuminimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
                super.mouseClicked(e);
            }
        });


        labelmenuhelp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"AUTHOR FURKAN KESGIN");
                super.mouseClicked(e);

            } });
        ////////////////////////////labellara eventlistner ekleme bitisi///////////////////////////////////
    }
//////////////////////////////MENU BITIS////////////////////////////////////////////////////////



    //////////////////////////TANIMLAMALAR///////////////////////////////////////////////
        JLabel labelmenuexit = new JLabel(new ImageIcon(this.getClass().getResource(("exit.png"))));

        JLabel labelmenuminimize = new JLabel(new ImageIcon(this.getClass().getResource(("minimize.png"))));
        JLabel labelmenuhelp = new JLabel(new ImageIcon(this.getClass().getResource(("help.png"))));
        JLabel labelshooted = new JLabel();
        JButton button = new JButton(new ImageIcon(this.getClass().getResource(("camera.png"))));
        JRadioButton radioButtonFullScreen = new JRadioButton("full screen",true);
        JRadioButton radioButtonManualScreen = new JRadioButton("Manual",false);
        ButtonGroup group = new ButtonGroup();
        String[] resimcombobox = {"png", "JPG"};
        JComboBox photo = new JComboBox(resimcombobox);
        JCheckBox lock = new JCheckBox("lock x-y");
        JFrame ff = new JFrame();
        String homedir;
        String rootdir;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm");
        String date = dtf.format(LocalDateTime.now());
        int coordinatex=0 , coordinatey=0, coordinatexx=0, coordinateyy=0;
        int jpg = 1;
        int png = 1;

    String [] kayityeri = {"DESKTOP", "ROOT"};
        JComboBox kayit = new JComboBox(kayityeri);


    ////////////////////cagirmalar\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        fullscreen fullscreen = new fullscreen();
////////////////////////////////////////////////////////////


        //////////////////////////////TANIMLAMALAR BITIS///////////////////////////////

    void screenmanual(String filename,String format){
        try {
            Thread.sleep(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Rectangle rectArea = new Rectangle(coordinatex, coordinatey, coordinatexx - coordinatex, coordinateyy - coordinatey);


        // Define an area of size 500*400 starting at coordinates (10,50)
        BufferedImage screenFullImage = robot.createScreenCapture(rectArea);
        try {
            ImageIO.write(screenFullImage, format, new File(filename));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    void shoot() {

        labelshooted.setForeground(Color.green);
        File dir = new File(System.getProperty("user.home") + "/Desktop/"+"Screenshoot");
        if (!dir.exists())
        dir.mkdir();
        else {
            System.out.println("directory already have");
        }
        System.out.println(date);
        homedir = System.getProperty("user.home") + "/Desktop/Screenshoot/";

        try {

            File dirroot = new File(new File(".").getCanonicalPath() + "/Screenshoot");
            if (!dirroot.exists())
                dirroot.mkdir();
            else {
                System.out.println("sirectory alredy have");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /////////////////////////////root directorysini almamiz icin asagidaki sekilde aldik .getCanonicalPath try catch istiyordu veya exeption ben try catch le yapmayi tercih ettim.
        try {
            rootdir = new File(".").getCanonicalPath()+"Screenshoot";
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filetype = photo.getSelectedItem().toString();
        int count=1;
        String filename="";
        while (true){
            File file = new File(homedir+File.separator+"ss"+count+"."+filetype);
            if (!file.exists()){
                filename = "ss"+count;
                break;
            }else{
                count++;
            }
        }

        String savedPlace = kayit.getSelectedItem().toString();

        if (savedPlace == "DESKTOP") {
            if (radioButtonFullScreen.isSelected()) {
                fullscreen.fullss(homedir + File.separator + filename + "." + filetype, filetype);
                labelshooted.setText(filename+"."+"saved");
            }
            if (radioButtonManualScreen.isSelected()) {
                screenmanual(homedir + File.separator + filename + "." + filetype, filetype);
                labelshooted.setText(filename+"."+"saved");

            }
        }
        else if(savedPlace == "ROOT"){
            if (radioButtonFullScreen.isSelected()) {
                fullscreen.fullss(rootdir + File.separator + filename + "." + filetype, filetype);
                labelshooted.setText(filename+"."+"saved");

            }
            if (radioButtonManualScreen.isSelected()) {
                screenmanual(rootdir + File.separator + filename + "." + filetype, filetype);
                labelshooted.setText(filename+"."+"saved");

            }
        }
    }
///////////////////////////////Navitive LIstenerin calismasi icin Native methodu gerekli//////////////////////////////
    void Native(){
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            ex.printStackTrace();

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(this);

            /////////////////////Native gereksiz consoleda gorunenleri siler\\\\\\\\\\\\\\\\\\
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }


    /////////////////////////////////////////////A ya basinca olacaklar //////////////////////////////////////////

    void pressA(){
        if (radioButtonManualScreen.isSelected()) {
            if (!lock.isSelected()) {
                PointerInfo pointerInfo = MouseInfo.getPointerInfo();
                Point nokta = pointerInfo.getLocation();
                coordinatex = (int) nokta.getX();
                coordinatey = (int) nokta.getY();
                labelshooted.setText("x : " + coordinatex + " y : " + coordinatey);
            }
        }
    }

    void pressS(){
        if (radioButtonManualScreen.isSelected()) {
            if (!lock.isSelected()) {
                PointerInfo pointerInfoo = MouseInfo.getPointerInfo();
                Point noktaa = pointerInfoo.getLocation();
                coordinatexx = (int) noktaa.getX();
                coordinateyy = (int) noktaa.getY();
                labelshooted.setText("x : " + coordinatexx + " y : " + coordinateyy);
            }
        }
    }

    void pressBackQuote(){
        try {
            shoot();
        }catch (Exception a){
            System.out.println("select the coodinate");
            labelshooted.setForeground(Color.red);
            labelshooted.setText("Coordinates!?");
        }
    }
    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            try {
                shoot();
            }catch (Exception a){
                System.out.println("select the coodinate");

                labelshooted.setForeground(Color.red);
                labelshooted.setText("Wrong Choice");

            }

        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
            if (e.getKeyCode() == NativeKeyEvent.KEY_LOCATION_UNKNOWN) {
                pressBackQuote();
            }
        System.out.println(e.getKeyCode()+ " " + e.getKeyChar()+" " + e.getRawCode());

            if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE){
                System.exit(0);
            }

            if (e.getKeyCode() == NativeKeyEvent.VC_A){
                pressA();
            }

            if(e.getKeyCode() == NativeKeyEvent.VC_S){
                pressS();
            }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }
}
