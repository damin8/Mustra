using Mustra.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using Mustra.Model;
using System.Windows.Controls.Primitives;

namespace Mustra
{
    /// <summary>
    /// MainWindow.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            this.DataContext = MainWindowViewModel.instance;
            InitializeComponent();
            this.MouseLeftButtonDown += MoveWindow;
            this.PreviewKeyDown += new KeyEventHandler(HandleEsc);
        }

        public void close(object sender, RoutedEventArgs r) 
        {
            this.Close();
        }
        private void HandleEsc(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Escape)
                Close();
        }
        void MoveWindow(object sender, MouseEventArgs e)
        {
            this.DragMove();
        }
        private void Hyperlink_Click(object sender, RoutedEventArgs e)
        {
            string artN = ArtistName.Text as string;
            if (artN == "")
            {
                MessageBox.Show("Artist Name is empty!");return;
            }
            string songN = SongName.Text as string;
            if (songN == "")
            {
                MessageBox.Show("SongName is empty!"); return;
            }
            string fanNum = FanNum.Text as string;
            if (fanNum == "")
            {
                MessageBox.Show("FanNumber is empty!"); return;
            }
            string videoChk = MVChk.IsChecked.Value? "yes":"no";
            string rule = RuleCombo.SelectedItem as string;

            InstancePacket instancePacket = new InstancePacket(
                artN,songN,fanNum,videoChk, rule);

            MainWindowViewModel mwvm = MainWindowViewModel.instance;


            mwvm.sendNewInstance(instancePacket);

            PredictUserControlViewModel pucv = PredictUserControlViewModel.instance;

            //pucv.AFR = fanNum;
            //pucv.SMR = videoChk;
            pucv.Rule = rule;
            PredictButton.IsChecked = true;
            mwvm.loadPredictPage(artN);
        }
    }
}
