﻿using System;
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

                //string address = "203.229.204.168";
                //string address = "203.229.204.173";
                //string address = "172.30.1.32";
                string address = "10.2.0.32";
                client.Connect(address, 7777);
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
                MessageBox.Show(tokens[0]);
                MessageBox.Show(tokens[1]);
                MessageBox.Show(tokens[2]);
                // 수신 받은거 처리 후
                ao.ClearBuffer();
            }
            catch(Exception e)
            {
                MessageBox.Show(e.ToString());
            }
        }
    }
}
