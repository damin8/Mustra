   M S B A M L   `   `   `  ���� A  =Mustra, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:MustraMustra  3clr-namespace:Mustra.ViewModelMustra.ViewModel      Mustra.MainWindow   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     @d2http://schemas.microsoft.com/expression/blend/2008     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     &localclr-namespace:Mustra     -vmclr-namespace:Mustra.ViewModel       � WindowStyle$
  None=� � 
ResizeMode$ NoResize=�$��0q� � AllowsTransparency .  � Title$ 
MainWindow��$	��654��$	��976����Z�  � 	Resources  �� 
TargetType   Hambuger �� Property �� Value �� 
TargetType	 � Cursor
 �� 
Background ��Name �� CornerRadius �� Color ��Name J� OpacityMask �� Triggers P� Property P� Value �� 
TargetName��%�  &	        �� " 	�.���  � �� �� " 	�.R��� $
	 Hand��
 Z� ._��� $ RadioBorder��$
��Auto��$��51��$ 0��$��1q�$��
-6,-2,-2,0q���Z� ���� $
 Gray��._�� $��38��.+��� $ RadioContent��$��Center=�$��Center=�
 �   ��� $ 	RadioMark��$��
-2,0,184,0q����	#FFCB2525$ 1��$��0�� P�  �@d�	IsChecked$
 trueY�. ��� $ RadioBorder�� � �� �� $ 	#FF3778D6��.���� 
�������$��5q� J� Effect 3  -System.Windows.Media.Effects.DropShadowEffect     Color$ 	#FFC7C5C5��._��  � ColumnDefinitions �� .+��� .+��� $��59�����	#FF3778D6 �� Orientation$ 
Horizontal=�.+��� $	��150��$��11,0,0,0q�.+��� $��Mustra!��$��48(� �� TextAlignment$ Center=�$��4,0,0,0q�$��Haettenschweiler)�
������� �� 
LineHeight$ 6���� $	��456��.+��� $"�� : The Music Predict Program��$��33(�$
 Left=�$��
0,14,25,35q�$��Haettenschweiler)�
��������� $	��206��$��	140,0,0,0q�.+��� $��45��.+��� $��Right=��� -    �� TextDecorations Z� .�.��� $��Right=�.+��� $��r��$��36(�
�������$
��Bold"�$��Webdings)�$��Right=�$��0,7,0,0q��� ���	#FF3778D6$��28��   $ 	#FFD1CBCB��._��� .+��� $��Ver 0.1��$
 Left=�$��17,-3,112,35q�$��Haettenschweiler)����	#FFAAA4A4$��23(��� $
��10,0q�$ 
Horizontal=�$	��551��.+��� $	��518��
�������$��0,4,0,0q�$	��365��$
��Left=� �� Padding$ 0q�   $ 	#FFB8B8B8��._��� .+��� $��0q�$	��520��._��� $ Vertical=�.+��� $��50��$��0,0,0,3q����	#FF3778D6���	#FF3778D6._��� .+��� $��Write Your Music��$��22(�$ Center=�$��Haettenschweiler)����	#FFF1F1F1$��0,15,0,0q��� $	��466��.+��� 
�������$��63��$��7,8,10,0q�._��� $ 
Horizontal=�.+��� $��40��$��40��$��12,0,0,0q�����  �� ImageSource$ Resources/singer.png�� j� Stretch$ Uniform=��� $	��244��$��12,1,0,0q�.+��� $��Artist Name��$��18(�$��0,6,0,0q�$��Gill Sans MT)��� $ 0��
�������$��0,0,0,1q����	#FF3778D6$��30��._��� -    ��Name$ 
ArtistName����Z� ��Z� �� 
�������$��63��$��7,8,10,0q�._��� $ 
Horizontal=�.+��� $��40��$��40��$��12,0,0,0q����� $ Resources/music.png��$ Uniform=��� $	��271��$��12,1,0,0q�.+��� $��	Song Name��$��18(�$��0,6,0,0q�$��Gill Sans MT)��� $ 0��
�������$��0,0,0,1q����	#FF3778D6$��30��$��0,0,26,0q�._��� -   $ SongName����Z� ��Z� �� 
�������$��63��$��7,8,10,0q�._��� $ 
Horizontal=�.+��� $��40��$��40��$��12,0,0,0q����� $ Resources/fan.png��$ Uniform=��� $	��244��$��12,1,0,0q�.+��� $��
Fan Number��$��18(�$��0,6,0,0q�$��Gill Sans MT)��� $ 0��
�������$��0,0,0,1q����	#FF3778D6$��30��._��� -   $ FanNum����Z� ��Z� �� 
�������$��63��$��7,8,10,0q�._��� $ 
Horizontal=�.+��� $��40��$��40��$��12,0,0,0q����� $ Resources/moive.png��$ Uniform=��� $	��244��$��12,1,0,0q�.+��� $��Music Video��$��18(�$��0,6,0,0q�$��Gill Sans MT)��� $ 0��
�������$��0,0,0,1q����	#FF3778D6$��30��._��� $ 
Horizontal=�.+��� $	��182��$��0q�$ 
Horizontal=�.+��� $	��138��$��if you have Music Video?��$��0,6,0,0q��� $ 0��$��16��$��1q�
���   �$��7,6,73,1q�$��18��._��� -    ��Name$ MVChk��$��0,0,0,0q���Z� ��Z� �� 
�������$��63��$��	7,14,10,0q�._��� $ 
Horizontal=�.+��� $��40��$��40��$��12,0,0,0q����� $ Resources/rule.png��$ Uniform=��� $	��244��$��12,1,0,0q�.+��� $��Rule Setting��$��18(�$��0,6,0,0q�$��Gill Sans MT)��� $ 0��
�������$��0,0,0,0q����	#FF3778D6$��30��._��� $ 
Horizontal=�.+��� $	��243��$��0q�$ 
Horizontal=�.+��� -     ��Name$  	RuleCombo��$	��166��! �� SelectedIndex$! 0������ *
RuleList+�� $ 20�����	#FF3778D6$��7,14,9,0q�$��49��   $ 	#FFCDCDCD��._��� �� -    Z� .��� .F��� $	��341��$��47��.+��� $��Predict��$��22(�$ Center=�$��Haettenschweiler)����	#FFF1F1F1$��0,15,0,0q��� $	��518��$��
10,4,578,0q�
�������$	��563��$ 0q�   $ 	#FFB8B8B8��._��� .+��� $��0q�$	��520��._��� $ Vertical=�.+��� $��50��$��0,0,0,3q����	#FF3778D6._��� $ 
Horizontal=�.+��� $	��188��.+��� $��47��$��1,1,1,1q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	� -   " 	�Name$" PredictButton��{�.  # 	� 	GroupName$
# menu��$��Predict��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��47��$ J� RenderTransformOrigin$$ 0.503,0.362&����� *LoadPredictPage+��Z� ��Z� �� $	��188��
�������.+��� $��47��$��1,1,1,1q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	� $
# menu��$��Classifier Model��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��47��$$ 0.503,0.362&����� *
LoadCMPage+��Z� ��Z� �� $	��188��
�������.+��� $��47��$��1,1,1,1q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	� $
# menu��$��Learning Curve��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��47��$$ 0.503,0.362&����� *
LoadLCPage+��Z� ��Z� �� $	��453��.+��� $	��453������ *ContentView+