using Mustra.InterFace;
using Mustra.ViewModel.LCVM;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Mustra.ViewModel
{
    class LCUserControlViewModel : INotifyPropertyChanged
    {
        private NBLCUserControlViewModel nBLCUserControlViewModel;
        private OneRuleLCUserControlViewModel oneRuleLCUserControlViewModel;
        private TreeLCUserControlViewModel treeLCUserControlViewModel;
        private TotalLCUserControlViewModel totalLCUserControlViewModel;
        private object contentview;



        public object Contentview
        {
            get { return this.contentview; }
            set
            {
                this.contentview = value;
                OnPropertyChanged("Contentview");
            }
        }

        public ICommand LoadNB { get; set; }
        public ICommand LoadTree { get; set; }
        public ICommand LoadOR { get; set; }
        public ICommand LoadTotal { get; set; }
        public LCUserControlViewModel()
        {
            nBLCUserControlViewModel = new NBLCUserControlViewModel();
            oneRuleLCUserControlViewModel = new OneRuleLCUserControlViewModel();
            treeLCUserControlViewModel = new TreeLCUserControlViewModel();
            totalLCUserControlViewModel = new TotalLCUserControlViewModel();
            this.Contentview = null;
            this.LoadNB = new Command(loadNBPage, CE);
            this.LoadTree = new Command(loadTreePage, CE);
            this.LoadOR = new Command(loadOneRulePage, CE);
            this.LoadTotal = new Command(loadTotalPage, CE);

        }
        public void loadTotalPage(object a)
        {
            this.Contentview = this.totalLCUserControlViewModel;
        }
        public void loadOneRulePage(object a)
        {
            this.Contentview = this.oneRuleLCUserControlViewModel;
        }
        public void loadNBPage(object a)
        {
            this.Contentview = this.nBLCUserControlViewModel;
        }
        public void loadTreePage(object a)
        {
            this.Contentview = this.treeLCUserControlViewModel;
        }
        public bool CE(object a) => true;

        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}