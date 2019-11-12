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
    class NBUserControlViewModel : INotifyPropertyChanged
    {
        public string nbCMString;
        public string NBCMString
        {
            get { return this.nbCMString; }
            set
            {
                this.nbCMString = value;
                this.OnPropertyChanged("NBCMString");
            }
        }
      
        public NBUserControlViewModel()
        {
            this.NBCMString =
                "Naive Bayes Classifier\n\n                       Class\nAttribute                  C             D             B             A\n                      (0.17)        (0.76)        (0.04)        (0.02)\n=======================================================================\nasr\n  mean            831290.4209   1124930.706  1409952.4455 10802723.8839\n  std. dev.      2142271.0167  5385607.7816  2580170.1861   2249201.835\n  weight sum               87           394            20             8\n  precision       165876.7583   165876.7583   165876.7583   165876.7583\n\nassr\n  mean             72089.4727    85016.2824   340600.5089   411399.4911\n  std. dev.       140450.5887   414890.1797   797664.3607   655281.6569\n  weight sum               86           386            20             8\n  precision        19134.8601    19134.8601    19134.8601    19134.8601\n\nassnr\n  mean               4696.946      4849.488    20756.0174    21591.6998\n  std. dev.          14124.44    18822.3351    42120.0232    18458.1973\n  weight sum               69           149            22             8\n  precision          855.1168      855.1168      855.1168      855.1168\n\nfan\n  mean             20790.1962     2220.3427   104336.4556   310268.3244\n  std. dev.        21874.4267     6372.8228   132769.5459   254359.6778\n  weight sum               89           396            22             8\n  precision         1556.2048     1556.2048     1556.2048     1556.2048\n\nvideo\n  No                     40.0         300.0           5.0           7.0\n  Yes                    51.0          98.0          19.0           3.0\n  [total]                91.0         398.0          24.0          10.0\n\n" +
                "\nCorrectly Classified Instances         435               84.466  %\nIncorrectly Classified Instances        80               15.534  %\nKappa statistic                          0.5782\nMean absolute error                      0.1381\nRoot mean squared error                  0.2714\nRelative absolute error                 72.6913 %\nRoot relative squared error             88.4254 %\nTotal Number of Instances              515     \n"
                ;

        }
        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
