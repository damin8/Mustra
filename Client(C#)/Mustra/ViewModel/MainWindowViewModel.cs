
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using Mustra.InterFace;
using Mustra.Model;

namespace Mustra.ViewModel
{
    class MainWindowViewModel : INotifyPropertyChanged
    {
        private static MainWindowViewModel _instance = null;
        private string _SelectedRule;
        public string SelectedRule
        {
            get
            {
                return this._SelectedRule;
            }
            set
            {
                this._SelectedRule = value;
                OnPropertyChanged("SelectedRule");
            }
        }
        public static MainWindowViewModel instance
        {
            get
            {
                if (_instance == null) _instance = new MainWindowViewModel();

                return _instance;
            }
        }
        private object _contentView;
        private PredictUserControlViewModel _predictUserControlViewModel;
        private CMUserControlViewModel _cMUserControlViewModel;
        private LCUserControlViewModel lCUserControlViewModel;

        public object ContentView
        {
            get { return this._contentView; }
            set
            {
                this._contentView = value;
                this.OnPropertyChanged("ContentView");
            }
        }

        public ICommand LoadPredictPage { get; set; }
        public ICommand LoadCMPage { get; set; }
        public ICommand LoadLCPage { get; set; }

        private ObservableCollection<string> ruleList;
        public ObservableCollection<string> RuleList
        {
            get { return this.ruleList; }
            set { this.ruleList = value; }
        }
        private MainWindowViewModel()
        {
            this.ContentView = null;
            this.LoadPredictPage = new Command(loadPredictPage,CE);
            this.LoadCMPage = new Command(loadCMPage, CE);
            this.LoadLCPage = new Command(loadLCPage, CE);
            lCUserControlViewModel = new LCUserControlViewModel();
            _predictUserControlViewModel = PredictUserControlViewModel.instance;
            _cMUserControlViewModel = new CMUserControlViewModel();
            RuleList = new ObservableCollection<string>();
            RuleList.Add("OneR");
            RuleList.Add("Naive Bayesian");
            RuleList.Add("J48");
        }

        public void sendNewInstance(InstancePacket instancePacket)
        {
            string[] attribute = new string[5];
            attribute[0] = instancePacket.Rule;
            attribute[1] = instancePacket.ArtistName;
            attribute[2] = instancePacket.SongName;
            attribute[3] = instancePacket.FanNumber;
            attribute[4] = instancePacket.VideoChk;
            // 이제 여기서 이 정보를 서버에게 넘기면 됨
            ((App)Application.Current).Send(attribute);
        }

        #region Page Change Operations
        public void loadPredictPage(object e)
        {
            this.ContentView = this._predictUserControlViewModel;
        }
       
        private void loadLCPage(object e)
        {
            this.ContentView = this.lCUserControlViewModel;
        }
        private void loadCMPage(object e)
        {
            this.ContentView = this._cMUserControlViewModel;
        }
        private Boolean CE(object e)=>true;
        #endregion


        protected void OnPropertyChanged(string name)
        {
         PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
