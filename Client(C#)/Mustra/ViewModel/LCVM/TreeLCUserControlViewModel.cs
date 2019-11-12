using System;
using Mustra.InterFace;
using Mustra.View;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;
using Mustra.View.LCUC.ExpandWindow;

namespace Mustra.ViewModel.LCVM
{
    class TreeLCUserControlViewModel
    {
        public ICommand Expand { get; set; }
        public TreeLCUserControlViewModel()
        {
            Expand = new Command(ExecuteExpand, CE);
        }
        public void ExecuteExpand(object a)
        {
            Window treeExpand = new TreeExpand();
            treeExpand.Show();
        }
        public bool CE(object a) => true;
    }
}
