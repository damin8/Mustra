using Mustra.ViewModel;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace Mustra
{
    /// <summary>
    /// App.xaml에 대한 상호 작용 논리
    /// </summary>

    public partial class App : Application
    {
        MustraSock MS;

        public void Send(string[] attribute)
        {
            MS.SendData(attribute);
        }

        public App()
        {
            InitializeComponent();
            MS = new MustraSock();
        }
    }

}
