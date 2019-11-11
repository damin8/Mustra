using JavaTest;
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

namespace JavaConnect
{
    /// <summary>
    /// MainWindow.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class MainWindow : Window
    {
        private CSSock socket = new CSSock();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string[] attribute = new string[6];
            attribute[0] = textBox1.Text.ToString();
            attribute[1] = textBox2.Text.ToString();
            attribute[2] = textBox3.Text.ToString();
            attribute[3] = textBox4.Text.ToString();
            attribute[4] = textBox5.Text.ToString();
            attribute[5] = textBox6.Text.ToString();
            socket.SendData(attribute);
            MessageBox.Show("전송 완료!");
        }

    }
}
