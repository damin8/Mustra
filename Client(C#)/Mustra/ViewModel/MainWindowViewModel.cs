using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using Mustra.InterFace;
using Mustra.ViewModel;

namespace Mustra.ViewModel
{
    class MainWindowViewModel : INotifyPropertyChanged
    {
        private MustraSock MS;
        private string algo;
        private string gsr;
        private string amg;
        private string mgs;
        private string afn;
        private string mv;
        private object _contentView;
        private PredictUserControlViewModel _predictUserControlViewModel;

        #region 프로퍼티
        
        public string Algo
        {
            get { return algo; }
            set
            {
                this.algo = value;
                this.OnPropertyChanged("Algo");
            }
        }
        public string Gsr
        {
            get { return gsr; }
            set
            {
                this.gsr = value;
                this.OnPropertyChanged("Gsr");
            }
        }

        public string Amg
        {
            get { return amg; }
            set
            {
                this.amg = value;
                this.OnPropertyChanged("Amg");
            }
        }
        
        public string Mgs
        {
            get { return mgs; }
            set
            {
                this.mgs = value;
                this.OnPropertyChanged("Mgs");
            }
        }

        public string Afn
        {
            get { return afn; }
            set
            {
                this.afn = value;
                this.OnPropertyChanged("Afn");
            }
        }

        public string Mv
        {
            get { return mv; }
            set
            {
                this.mv = value;
                this.OnPropertyChanged("Mv");
            }
        }
        public object ContentView
        {
            get { return this._contentView; }
            set
            {
                this._contentView = value;
                this.OnPropertyChanged("ContentView");
            }
        }
        #endregion

        public ICommand LoadPredictPage { get; set; }
        public ICommand Predict { get; set; }


        public MainWindowViewModel()
        {
            this.ContentView = null;
            this.LoadPredictPage = new Command(loadPredictPage,CE);
            _predictUserControlViewModel = new PredictUserControlViewModel();
            Predict = new Command(goPredict, CE);
            MS = new MustraSock();
        }

        public void goPredict(object obj)
        {
            string[] attribute = new string[6];
            attribute[0] = "Tree";
            attribute[1] = Gsr.ToString();
            attribute[2] = Amg.ToString();
            attribute[3] = Mgs.ToString();
            attribute[4] = Afn.ToString();
            attribute[5] = Mv.ToString();
            MS.SendData(attribute);
        }

        #region Page Change Operations
        private void loadPredictPage(object e) =>this._contentView = this._predictUserControlViewModel;
        private Boolean CE(object e)=>true;
        #endregion


        protected void OnPropertyChanged(string name)
        {
         PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
