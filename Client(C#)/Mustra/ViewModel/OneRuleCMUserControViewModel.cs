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
            this.OneRuleCMString = "fan:\n\t < 10070.5\t->D\n\t < 19978.5\t->C\n\t < 24222.5\t->D\n\t < 67431.0\t->C\n\t < 177787.0\t->B\n\t < 652940.0\t->A\n\t >= 652940.0\t->B\n(444 / 515 instances correct)\n";
            this.OneRuleCMString2 = "\nCorrectly Classified Instances         429               83.301  %\nIncorrectly Classified Instances        86               16.699  %\nKappa statistic                          0.5318\nMean absolute error                      0.0835\nRoot mean squared error                  0.289 \nRelative absolute error                 43.9419 %\nRoot relative squared error             94.1366 %\nTotal Number of Instances              515     \n";
            this.OneRuleCMString += this.OneRuleCMString2;   
        }
        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
