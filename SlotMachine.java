import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class SlotMachine extends JFrame {
//making the variables
    Integer betCredit = 10;
    Integer betArea = 0;
    Integer totalBet = 0;
    int wins = 0;
    int loses = 0;
    int avgbet = 0;

//making the GUI Lables and panels
    boolean spin = false;
    JFrame statframe = new JFrame();
    JPanel panel = new JPanel();
    JPanel butpanel = new JPanel();
    JPanel imagePanel = new JPanel();
    JFrame mainFrame = new JFrame("Slot Machine");
    JLabel welcomeLabel = new JLabel("Welcome to Win or Lose Game !!");
    JLabel pressLabel = new JLabel("Press Button to Start");
    JLabel creditLabel = new JLabel("Credits : 10");
    JLabel betLabel = new JLabel("Bet Area");
    JLabel labResult = new JLabel();
    JLabel labOption = new JLabel();

    //Making the buttons
    JButton butStart = new JButton("START");
    JButton butSpin = new JButton("SPIN");
    JButton butCoin = new JButton("Add Coin");
    JButton butReset = new JButton("Reset");
    JButton butBetOne = new JButton("Bet One");
    JButton butBetMax = new JButton("Bet Max");
    JButton butStatistics = new JButton("Statics");
    JButton butsave = new JButton("Save");



    //making img for reel and m1 for find win or lose
    JLabel img1 = new JLabel();
    JLabel img2 = new JLabel();
    JLabel img3 = new JLabel();
    int m1 = 0;
    int m2 = 0;
    int m3 = 0;

    CountDownLatch countDownLatch = new CountDownLatch(2);

  //launching
    public void launch() {
        butStart.setSize(1100, 1500);//1100,1500
        welcomeLabel.setSize(1100, 1500);

        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.YELLOW);
        panel.setSize(1500, 500);

        final GridBagConstraints gbc = new GridBagConstraints();


        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        Font font = new Font(Font.DIALOG, Font.PLAIN, 32);
        welcomeLabel.setFont(font);

        panel.add(welcomeLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(pressLabel, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(butStart, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        labResult.setFont (labResult.getFont ().deriveFont (64.0f));
        panel.add(labResult,gbc );

        mainFrame.add(panel);
        mainFrame.setSize(1600, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        ActionListener onStartGame = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                butStart.setVisible(false);
                panel.remove(butStart);
                panel.remove(pressLabel);

                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 3;
                panel.add(creditLabel, gbc);


//
//                gbc.fill = GridBagConstraints.HORIZONTAL;
//                gbc.gridx = 0;
//                gbc.gridy = 1;
//                panel.add(labOption,gbc);
//
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 4;//4
                panel.add(betLabel, gbc);

                butpanel.setLayout(new FlowLayout());
                butpanel.add(butCoin);
                butpanel.add(butBetOne);
                butpanel.add(butBetMax);
                butpanel.add(butReset);
                butpanel.add(butStatistics);
                gbc.gridx = 0;
                gbc.gridy = 5;
                panel.add(butpanel,gbc);

                imagePanel.setLayout(new FlowLayout());

               gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 6;
                img1.setIcon(new ImageIcon("images/bell.png"));
                imagePanel.add(img1);
                img2.setIcon(new ImageIcon("images/cherry.png"));
                imagePanel.add(img2);
                img3.setIcon(new ImageIcon("images/redseven.png"));
                imagePanel.add(img3);
                panel.add(imagePanel, gbc);

                gbc.gridy = 7;
                panel.add(butSpin, gbc);
                butSpin.setVisible(false);



            }
      };
        butSpin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




     //making the reelSpining
                Reel reel1 = new Reel() {
                    public void run() {
                        // implementation

                        final List<Symbol> randSymbol = spin();
                        while (spin) {
                            for (int i = 0; i < 6; i++) {
                                if (spin) {
                                    final int c = i;


                                    img1.setIcon(new ImageIcon(randSymbol.get(c).getImage()));
                                    m1 = randSymbol.get(c).getValue();
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        System.out.println("");
                                    }
                                }

                            }
                        }



                    }
                };

                Reel reel2 = new Reel() {
                    public void run() {
                        // implementation

                        final List<Symbol> randSymbol = spin();

                        while (spin) {
                            for (int i = 0; i < 6; i++) {
                                if (spin) {
                                    final int c = i;


                                    img2.setIcon(new ImageIcon(randSymbol.get(c).getImage()));
                                    m2 = randSymbol.get(c).getValue();

                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        System.out.println("");
                                    }
                                }
                            }
                        }



                    }
                };

                Reel reel3 = new Reel() {
                    public void run() {
                        // implementation

                        final List<Symbol> randSymbol = spin();

                        while (spin) {
                            for (int i = 0; i < 6; i++) {
                                if (spin) {
                                    final int c = i;


                                    img3.setIcon(new ImageIcon(randSymbol.get(c).getImage()));
                                    m3 = randSymbol.get(c).getValue();


                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        System.out.println("");
                                    }
                                }
                            }
                        }


                    }
                };





                if (spin) {
                    spin = false;

                    try {
                        reel1.join();
                        reel2.join();
                        reel3.join();
                        displayResults();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    spin = true;
                    countDownLatch = new CountDownLatch(2);
                }


                    reel1.start();
                    reel2.start();
                    reel3.start();



            }
        });


        butStart.addActionListener(onStartGame);

        ActionListener one = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaBet();


            }
        };
        butBetOne.addActionListener(one);

        ActionListener max = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maxCredit();
            }
        };
        butBetMax.addActionListener(max);

        ActionListener coin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoin();
            }
        };


        butCoin.addActionListener(coin);

        ActionListener statistics = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statistics();
            }
        };

        butStatistics.addActionListener(statistics);





        ActionListener reset = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        };
        butReset.addActionListener(reset);


    }

   //making the maxCredit
    private void maxCredit() {
        if (betArea < 3 && betCredit >2) {
            betCredit = betCredit - (3- betArea);
            this.totalBet = this.totalBet + (3-betArea);
            this.betArea = 3;
            betLabel.setText("Bet Area: " + betArea);
            butSpin.setVisible(true);
            butCoin.setVisible(true);
        }
        creditLabel.setText(String.format("Credits :%d", betCredit));

    }
   //making the add Coin
    private void addCoin() {
        betCredit++;
        creditLabel.setText(String.format("Credits :%d", betCredit));
        butSpin.setVisible(true);
    }
   //making the bet area
    private void areaBet() {
        if (betArea < 3 && betCredit > 0) {
            betArea++;
            totalBet++;
            betCredit--;
            creditLabel.setText(String.format("Credits : %d", betCredit));
            betLabel.setText("Bet Area: " + betArea);
            butSpin.setVisible(true);
        }
    }
   //maiking the reset
    private void reset() {
        betCredit = betCredit + betArea;
        totalBet = totalBet - betArea;
        betArea = 0;
        creditLabel.setText("Credit :" + betCredit);
        betLabel.setText("Bet Area :" + betArea);
        butSpin.setVisible(false);
        //labResult.setVisible(false);
    }
    //making the statistics
    private void statistics() {
        statframe.setSize(200, 200);
        statframe.setLocationRelativeTo(null);
        statframe.setVisible(true);


        JPanel statpanel = new JPanel();
        statframe.add(statpanel);
        statpanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labwins = new JLabel("Wins : " + wins);
        JLabel labloss = new JLabel("Loses : " + loses);
        JLabel labavg = new JLabel("Average Bet : " + avgbet);

        gbc.gridx = 0;
        gbc.gridy = 0;
        statpanel.add(labwins, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        statpanel.add(labloss, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        statpanel.add(labavg, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        statpanel.add(butsave, gbc);

        butsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PrintWriter writer = new PrintWriter("output.txt");
                    writer.println("Wins=" +wins);
                    writer.println("Loses=" +loses);
                    avgbet = totalBet/(wins+loses);
                    writer.println("Average=" +avgbet);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
                    Date date = new Date();
                    writer.println((dateFormat.format(date)));
                    writer.flush();
                    writer.close();

                } catch (IOException err) {

                    // do something
                }
            }
        });
    }






  //Displaying the results
    private void displayResults() {
        System.out.printf("results %d,%d,%d%n", m1, m2, m3);

        if (m1 == m2 && m1 == m3 &&(m1 != 0 || m2 !=0 || m3 !=0)) {
            labResult.setText(String.format("Win"));
            int q = (m1*betArea)+betCredit;

            creditLabel.setText("Credit :" + q);
            this.wins++;
            this.betArea =0;
            this.avgbet = totalBet/(wins+loses);
            butSpin.setVisible(false);
        }
        else if
            (m1==m2 || m2==m3 ||m1==m3){
            labResult.setText(String.format("Try Again" ));
            betLabel.setText("betArea :"+ this.betArea);
            this.avgbet = totalBet/(wins+loses);
            }
        else{
            labResult.setText(String.format("Lost"));
            betLabel.setText("betArea :0");
            JLabel labloss = new JLabel("Loses : " + loses);
            this.loses++;
            this.avgbet = totalBet/(wins+loses);
            this.betArea =0;
            butSpin.setVisible(false);

            if(betCredit<1){
                labResult.setText("Game Over");
                butStart.setText("Restart");
                butStart.setVisible(true);
            }
        }
            }
        }


