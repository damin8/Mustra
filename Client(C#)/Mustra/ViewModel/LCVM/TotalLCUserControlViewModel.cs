using Mustra.InterFace;
using Mustra.View;
using Mustra.View.LCUC.ExpandWindow;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;

namespace Mustra.ViewModel.LCVM
{
    class TotalLCUserControlViewModel
    {
        public ICommand Expand { get; set; }
        public TotalLCUserControlViewModel()
        {
            Expand = new Command(ExecuteExpand, CE);
        }
        public void ExecuteExpand(object a)
        {
            Window treeExpand = new TotalExpand();
            treeExpand.Show();
        }
        public bool CE(object a) => true;
    }
}
