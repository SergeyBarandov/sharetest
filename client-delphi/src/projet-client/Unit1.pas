unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,  IdBaseComponent, IdComponent, IdTCPConnection, IdTCPClient,
  System.Win.ScktComp;

type
  TForm1 = class(TForm)
    Memo1: TMemo;
    ed_str: TEdit;
    Button1: TButton;
    ed_ip: TEdit;
    Ed_port: TEdit;
    bt_connect: TButton;
    bt_disconnect: TButton;
    ClientSocket1: TClientSocket;

    procedure Button1Click(Sender: TObject);

    procedure bt_connectClick(Sender: TObject);
    procedure ClientSocket1Connecting(Sender: TObject;
      Socket: TCustomWinSocket);
    procedure ClientSocket1Disconnect(Sender: TObject;
      Socket: TCustomWinSocket);
    procedure ClientSocket1Connect(Sender: TObject; Socket: TCustomWinSocket);
    procedure ClientSocket1Write(Sender: TObject; Socket: TCustomWinSocket);
    procedure ClientSocket1Read(Sender: TObject; Socket: TCustomWinSocket);
    procedure bt_disconnectClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
implementation

{$R *.dfm}

procedure TForm1.bt_connectClick(Sender: TObject);
begin
ClientSocket1.host:=ed_ip.Text;
ClientSocket1.Port:=strtoint(Ed_port.Text);
ClientSocket1.active:=true
end;

procedure TForm1.bt_disconnectClick(Sender: TObject);
begin
ClientSocket1.Active:=false;
end;

procedure TForm1.Button1Click(Sender: TObject);
begin
if ClientSocket1.Active then
ClientSocket1.Socket.SendText(ed_str.Text)
else ShowMessage('Not connected');
end;


procedure TForm1.ClientSocket1Connect(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Connect');
end;

procedure TForm1.ClientSocket1Connecting(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Connecting...');
end;

procedure TForm1.ClientSocket1Disconnect(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Disconnect');
end;

procedure TForm1.ClientSocket1Read(Sender: TObject; Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('read from server: '+ Socket.ReceiveText);
end;

procedure TForm1.ClientSocket1Write(Sender: TObject; Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Sending string');
end;

end.
