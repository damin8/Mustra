   M S B A M L   `   `   `  ���� A  =Mustra, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:Mustra.ViewMustra.View  3clr-namespace:Mustra.ViewModelMustra.ViewModel      Mustra.View.CMUserControl   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     @d2http://schemas.microsoft.com/expression/blend/2008     +localclr-namespace:Mustra.View     -vmclr-namespace:Mustra.ViewModel       � DataContext  -  'Mustra.ViewModel.CMUserControlViewModel   � 	Resources  �� 
TargetType   Hambuger �� Property �� Value �� 
TargetType � Cursor �� 
Background ��Name	 �� CornerRadius
 �� Color ��Name J� OpacityMask �� Triggers P� Property P� Value �� 
TargetName��%�  &	        �� " 	�.���  � �� �� " 	�.R��� $
 Hand�� Z� ._��� $ RadioBorder��$
��Auto��$��51��$	 0��$��1q�$��
-6,-2,-2,0q���Z� ���� $

 Gray��._�� $��38��.+��� $ RadioContent��$��Center=�$��Center=�
 �   ��� $ 	RadioMark��$��
-2,0,184,0q����	#FFCB2525$	 1��$��0�� P�  �@d�	IsChecked$
 trueY�. ��� $ RadioBorder�� � �� �� $
 	#FF3778D6��.��� 
�������.+��� .+��� $��46�����	#FF3778D6.+���  �� TextAlignment$ Center=�$��Classifier Model��$��35��$��	0,5.2,0,0q�
�������$��24(�$��Impact)���  �� Orientation$ 
Horizontal=�$��39��
�������.+��� ._��� $	��188��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	�  	� 	GroupName$
 menu��$��OneRule��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38�� J� RenderTransformOrigin$ 0.503,0.362&����� *LoadOneRulePage+��Z� ��Z� �� ._��� $	��188��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	� $
 menu��$��
NaiveBayes��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38��$ 0.503,0.362&����� *
LoadNBPage+��Z� ��Z� �� ._��� $	��188��.+��� $��38��$��1,1,1,1q�$��2,0,0,0q�._��� $ 
Horizontal=�$��Center=�$��-1q�$	��188��.+�	� $
 menu��$	��J48��#��[  $	��187��$��20(����	#FFF1F1F1$��Impact)�$��Center=�$��Center=�$��38��$ 0.503,0.362&����� *LoadTreePage+��Z� ��Z� �� $	��368��.+��� $	��353��$��0,6,0,0q�._��� .+��� $	��352������ *Contentview+