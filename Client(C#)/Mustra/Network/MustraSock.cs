
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Threading.Tasks;
using System.Threading;
using System.Windows;

namespace Mustra.ViewModel
{
    class MustraSock
    {
        public bool nowconnect = false;
        private Socket client = null;

        public class AsyncObject
        {
            public byte[] Buffer;
            public Socket WorkingSocket;
            public readonly int BufferSize;
            public AsyncObject(int bufferSize)
            {
                BufferSize = bufferSize;
                Buffer = new byte[BufferSize];
            }

            public void ClearBuffer()
            {
                Array.Clear(Buffer, 0, BufferSize);
            }
        }

        public void CloseSock()
        {
            client.Close();
        }
        public MustraSock()
        {
            try
            {
                client = new Socket(AddressFamily.InterNetwork,
                    SocketType.Stream, ProtocolType.IP);
                string address = "52.231.154.88";
                //string address = "10.2.2.73";
                //string address = "203.229.204.173";
                //string address = "172.30.1.32";
                //string address = "10.2.0.191";
                client.Connect(address, 8888);
                MessageBox.Show("연결 성공!");
                AsyncObject ao = new AsyncObject(4096);
                ao.WorkingSocket = client;
                nowconnect = true;
                //ao.WorkingSocket.BeginReceive(ao.Buffer, 0, 4096, 0, DataReceived, ao);
            }
            catch (Exception e)
            {
                MessageBox.Show(e.ToString());
                nowconnect = false;
            }
        }

        /*public void DataReceived(IAsyncResult ar)
        {
            AsyncObject obj = (AsyncObject)ar.AsyncState;
            try
            {
                string text = Encoding.UTF8.GetString(obj.Buffer);
                string[] tokens = text.Split('~');
                if (tokens.Length == 1) return;
                MessageBox.Show(tokens[0]);
                MessageBox.Show(tokens[1]);
                MessageBox.Show(tokens[2]);
                // 수신 받은거 처리 후
                obj.ClearBuffer();
                //obj.WorkingSocket.BeginReceive(obj.Buffer, 0, 4096, SocketFlags.None, DataReceived, obj);
                obj.WorkingSocket.Receive(obj.Buffer);
            }
            catch (Exception e)
            {
                MessageBox.Show(e.ToString());
            }
        }*/

        public void SendData(string[] attribute)
        {
            try
            {
                AsyncObject ao = new AsyncObject(4096);
                ao.WorkingSocket = client;
                int size = attribute.Length;
                string Data = "";
                for (int i = 0; i < size; i++)
                {
                    Data += attribute[i];
                    Data += "/";
                }
                byte[] bD = Encoding.UTF8.GetBytes(Data + "\r\n");
                ao.WorkingSocket.Send(bD);
                ao.WorkingSocket.Receive(ao.Buffer);
                string text = Encoding.UTF8.GetString(ao.Buffer);
                string[] tokens = text.Split('~');
                if (tokens.Length == 1) return;
                if (tokens[0] == "A")
                {
                    PredictUserControlViewModel.instance.Arank = "yes";
                }
                else if (tokens[0] == "B")
                {
                    PredictUserControlViewModel.instance.Brank = "yes";
                }
                else if (tokens[0] == "C")
                {
                    PredictUserControlViewModel.instance.Crank = "yes";
                }
                else
                {
                    PredictUserControlViewModel.instance.Drank = "yes";
                }
                PredictUserControlViewModel.instance.ASR = tokens[1].ToString();
                PredictUserControlViewModel.instance.ASSR = tokens[2].ToString();
                PredictUserControlViewModel.instance.ASSNR = tokens[3].ToString();
                PredictUserControlViewModel.instance.AFR = tokens[4].ToString();
                PredictUserControlViewModel.instance.SMR = tokens[5].ToString();
                //0번 predict 1번 asr 2번 assr 3번 assnr 4번 videoChk
                // 수신 받은거 처리 후

                ao.ClearBuffer();
            }
            catch (Exception e)
            {
                MessageBox.Show(e.ToString());
            }
        }
    }
}