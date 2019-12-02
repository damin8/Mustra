using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using Mustra.InterFace;

namespace Mustra.ViewModel
{
    class OneRuleCMUserControViewModel : INotifyPropertyChanged
    {
        public string oneRuleCMString;
        public string oneRuleCMString2;

        public string OneRuleCMString
        {
            get { return this.oneRuleCMString; }
            set
            {
                this.oneRuleCMString = value;
                this.OnPropertyChanged("OneRuleCMString");
            }
        }
        public string OneRuleCMString2
        {
            get { return this.oneRuleCMString2; }
            set
            {
                this.oneRuleCMString2 = value;
                this.OnPropertyChanged("OneRuleCMString2");
            }
        }
        public OneRuleCMUserControViewModel()
        {
            this.OneRuleCMString = "fan:\n\t< 10070.5\t-> D\n\t< 67431.0\t-> C\n\t< 177787.0\t-> B\n\t< 652940.0\t-> A\n\t>= 652940.0\t-> B\n(437/509 instances correct)\n";
            this.OneRuleCMString2 = "\nCorrectly Classified Instances         428               84.0864 %\nIncorrectly Classified Instances        81               15.9136 %\nKappa statistic                          0.5563\nMean absolute error                      0.0796\nRoot mean squared error                  0.2821\nRelative absolute error                 42.0074 %\nRoot relative squared error             92.0466 %\nTotal Number of Instances              509     \n";
            this.OneRuleCMString += this.OneRuleCMString2;   
        }
        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
