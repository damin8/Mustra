using Mustra.InterFace;
using Mustra.View;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Input;


namespace Mustra.ViewModel
{
    class TreeUserControlViewModel
    {
        public ICommand Expand { get; set; }
        public TreeUserControlViewModel()
        {
            Expand = new Command(ExecuteExpand, CE);
        }
        public void ExecuteExpand(object a)
        {
            Window treeExpand = new Tree();
            treeExpand.Show();
        }
        public bool CE(object a) => true;
    }
}
