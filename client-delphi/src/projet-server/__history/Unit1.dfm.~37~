object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Server'
  ClientHeight = 224
  ClientWidth = 255
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Memo1: TMemo
    Left = 5
    Top = 71
    Width = 246
    Height = 150
    TabOrder = 0
    WordWrap = False
  end
  object Button1: TButton
    Left = 162
    Top = 40
    Width = 89
    Height = 25
    Caption = 'Start Server'
    TabOrder = 1
  end
  object ed_ip: TEdit
    Left = 8
    Top = 16
    Width = 243
    Height = 21
    TabOrder = 2
    Text = '127.0.0.1'
  end
  object Ed_port: TEdit
    Left = 8
    Top = 43
    Width = 148
    Height = 21
    TabOrder = 3
    Text = '5431'
  end
  object ServerSocket1: TServerSocket
    Active = False
    Port = 0
    ServerType = stNonBlocking
    OnClientConnect = ServerSocket1ClientConnect
    OnClientDisconnect = ServerSocket1ClientDisconnect
    OnClientRead = ServerSocket1ClientRead
    OnClientWrite = ServerSocket1ClientWrite
    Left = 24
    Top = 88
  end
end
