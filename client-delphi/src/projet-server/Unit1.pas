unit Unit1;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls, Data.DB,
   IdContext,
  IdCustomTCPServer, IdTCPServer, IdIntercept, IdBaseComponent, IdComponent,
  System.Win.ScktComp;

type
  TForm1 = class(TForm)
    Memo1: TMemo;
    Button1: TButton;
    ed_ip: TEdit;
    Ed_port: TEdit;
    ServerSocket1: TServerSocket;
    procedure FormShow(Sender: TObject);
    procedure ServerSocket1ClientConnect(Sender: TObject;
      Socket: TCustomWinSocket);
    procedure ServerSocket1ClientRead(Sender: TObject;
      Socket: TCustomWinSocket);
    procedure ServerSocket1ClientDisconnect(Sender: TObject;
      Socket: TCustomWinSocket);
    procedure ServerSocket1ClientWrite(Sender: TObject;
      Socket: TCustomWinSocket);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.FormShow(Sender: TObject);
begin
ServerSocket1.Port:=StrToInt(Ed_port.Text);
ServerSocket1.Active:=true;
Memo1.Lines.Add('Start server');
end;

procedure TForm1.ServerSocket1ClientConnect(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Client Connected');
end;

procedure TForm1.ServerSocket1ClientDisconnect(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Client disconnected');
end;

procedure TForm1.ServerSocket1ClientRead(Sender: TObject;
  Socket: TCustomWinSocket);
  var str:string;
begin
str:=string(Socket.ReceiveText);
Memo1.Lines.Add('Read message: ' +str +' length: ' + inttostr(Length(str)) );
if Length(str) > 3 then ServerSocket1.Socket.Connections[0].SendText('text: '+str+' Received!')

end;

procedure TForm1.ServerSocket1ClientWrite(Sender: TObject;
  Socket: TCustomWinSocket);
begin
Memo1.Lines.Add('Send str');
end;

end.
