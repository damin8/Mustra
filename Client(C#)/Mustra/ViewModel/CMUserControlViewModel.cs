using Mustra.InterFace;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace Mustra.ViewModel
{
    class CMUserControlViewModel : INotifyPropertyChanged
    {
        private OneRuleCMUserControViewModel oneRuleCMUserControViewModel;
        private NBUserControlViewModel nBUserControlViewModel;
        private TreeUserControlViewModel treeUserControlViewModel;
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

        public ICommand LoadOneRulePage { get; set; }
        public ICommand LoadNBPage { get; set; }
        public ICommand LoadTreePage { get; set; }

        public CMUserControlViewModel()
        {
            oneRuleCMUserControViewModel = new OneRuleCMUserControViewModel();
            nBUserControlViewModel = new NBUserControlViewModel();
            treeUserControlViewModel = new TreeUserControlViewModel();
            this.Contentview = null;
            this.LoadOneRulePage = new Command(loadOneRulePage, CE);
            this.LoadNBPage = new Command(loadNBPage, CE);
            this.LoadTreePage = new Command(loadTreePage, CE);
            
        }

        public void loadOneRulePage(object a) {
            this.Contentview = this.oneRuleCMUserControViewModel;
        }
        public void loadNBPage(object a)
        {
            this.Contentview = this.nBUserControlViewModel;
        }
        public void loadTreePage(object a)
        {
            this.Contentview = this.treeUserControlViewModel;
        }
        public bool CE(object a) => true;

        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
