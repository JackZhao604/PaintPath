
clear;
img=imread('/home/jack/PaintPath/GenerateFile/data.png');
#img=imread('/home/jack/PaintPath/GenerateFile/3.jpg');
#image(img)
figure 1
imshow(img);
hold on
matrix=load('/home/jack/PaintPath/GenerateFile/10100124');
x=matrix(:,1);
y=matrix(:,2);
z=matrix(:,3);

figure 1 
plot(x,y,'-r','LineWidth',3);

title("Path Figure 1")


hold on