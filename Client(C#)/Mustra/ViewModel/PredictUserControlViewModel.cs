using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mustra.ViewModel
{
    class PredictUserControlViewModel : INotifyPropertyChanged
    {
        private static PredictUserControlViewModel _instance;
        public static PredictUserControlViewModel instance
        {
            get
            {
                if (_instance == null)
                    _instance = new PredictUserControlViewModel();
                return _instance;
            }
        }
        #region hide
        private string arank;
        private string brank;
        private string crank;
        private string drank;
        private string _ASR;
        private string _ASSR;
        private string _ASNR;
        private string _AFR;
        private string _SMR;
        private string _rule;
        #endregion

        #region property
        public string Arank
        {
            get
            {
                //this.brank = "no";
                //this.crank = "no";
                //this.drank = "no";
                return this.arank;
            }
            set
            {
                this.brank = "no";
                this.crank = "no";
                this.drank = "no";
                this.arank = value;
                OnPropertyChanged("Arank");
                OnPropertyChanged("Brank");
                OnPropertyChanged("Crank");
                OnPropertyChanged("Drank");
            }
        }
        public string Brank
        {
            get
            {
                //this.arank = "no";
                //this.crank = "no";
                //this.drank = "no";
                return this.brank;
            }
            set
            {
                this.arank = "no";
                this.crank = "no";
                this.drank = "no";
                this.brank = value;
                OnPropertyChanged("Arank");
                OnPropertyChanged("Brank");
                OnPropertyChanged("Crank");
                OnPropertyChanged("Drank");
            }
        }
        public string Crank
        {
            get
            {
                //this.arank = "no";
                //this.brank = "no";
                //this.drank = "no";
                return this.crank;
            }
            set
            {
                this.arank = "no";
                this.brank = "no";
                this.drank = "no";
                this.crank = value;
                OnPropertyChanged("Arank");
                OnPropertyChanged("Brank");
                OnPropertyChanged("Crank");
                OnPropertyChanged("Drank");
            }
        }
        public string Drank
        {
            get
            {
                //this.brank = "no";
                //this.crank = "no";
                //this.arank = "no";
                return this.drank;
            }
            set
            {
                this.brank = "no";
                this.crank = "no";
                this.arank = "no";
                this.drank = value;
                OnPropertyChanged("Arank");
                OnPropertyChanged("Brank");
                OnPropertyChanged("Crank");
                OnPropertyChanged("Drank");
            }
        }
        public string ASR { get => _ASR; set {
                this._ASR = value;
                OnPropertyChanged("ASR");
            } }
        public string ASSR { get => _ASSR; set
            {
                this._ASSR = value;
                OnPropertyChanged("ASSR");
            }
        }
        public string ASSNR{ get => _ASNR; set
            {
                this._ASNR = value;
                OnPropertyChanged("ASNR");
            }
        }
        public string AFR { get => _AFR; set
            {
                this._AFR = value;
                OnPropertyChanged("AFR");
            }
        }
        public string SMR { get => _SMR; set
            {
                this._SMR = value;
                OnPropertyChanged("SMR");
            }
        }

        public string Rule {
            get => this._rule;
            set {
                this._rule = value;
                OnPropertyChanged("Rule");
            } }
        #endregion

        private PredictUserControlViewModel()
        {
            //server 에서 받으면 됩니다.
            /*
            Arank = "no";
            Brank = "no";
            Crank = "yes";
            Drank = "no";
           ASR  ="120";
           ASSR="120" ;
            ASSNR = "120";
           AFR  ="120";
           SMR ="120" ;*/
        }



        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
