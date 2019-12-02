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
                "Naive Bayes Classifier\n\n                       Class\nAttribute                  C             D             B             A\n                      (0.17)        (0.77)        (0.04)        (0.02)\n=======================================================================\nasr\n  mean            847114.8828  1135181.3157  1420047.5704 10754772.0406\n  std. dev.      2159448.1606  5410871.8396  2598643.9583  2244418.1515\n  weight sum               85           390            20             8\n  precision         167064.42     167064.42     167064.42     167064.42\n\nassr\n  mean              73496.529    84513.5657   341381.0742   408695.6522\n  std. dev.       142174.9188   416009.0541   797680.5027   652975.4825\n  weight sum               84           383            20             8\n  precision        19232.7366    19232.7366    19232.7366    19232.7366\n\nassnr\n  mean              4706.5462     4887.7614    20736.3092    21478.2864\n  std. dev.        14145.4398    18882.3735    42129.5433    18620.5719\n  weight sum               69           148            22             8\n  precision          859.1315      859.1315      859.1315      859.1315\n\nfan\n  mean             21075.3261     2224.4857   104339.8564   309912.9411\n  std. dev.        21997.0675     6392.5772   132784.7695   254349.4695\n  weight sum               87           392            22             8\n  precision         1571.1683     1571.1683     1571.1683     1571.1683\n\nvideo\n  No                     39.0         297.0           5.0           7.0\n  Yes                    50.0          97.0          19.0           3.0\n  [total]                89.0         394.0          24.0          10.0\n\n"
                + "\nCorrectly Classified Instances         431               84.6758 %\nIncorrectly Classified Instances        78               15.3242 %\nKappa statistic                          0.5865\nMean absolute error                      0.1344\nRoot mean squared error                  0.2682\nRelative absolute error                 70.9817 %\nRoot relative squared error             87.5057 %\nTotal Number of Instances              509     \n"
                ;

        }
        protected void OnPropertyChanged(string name)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
