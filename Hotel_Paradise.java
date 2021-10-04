import java.util.*;
class hotel_paradise
{  
    int ar[]=new int[16],q[]=new int[16];String name;
    static double sum,qs=0;
    int roomno;
    int temp;
    int ans;static int Hotel_bill;
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String Customer=null;
        int roomNum=1;
        int Option;
        String[] hotel=new String[12];
        int[] day=new int[13];
        for(int f=0;f<13;f++)
        {
            day[f]=0;
        }
        hotel_paradise obj=new hotel_paradise();
        obj.initialise(hotel);
        while (roomNum<11)
        {
            sum*=0;
            System.out.println();
            System.out.println("Hotel Booking Options");
            System.out.println("1: To View all rooms");
            System.out.println("2: For customer check-in");
            System.out.println("3: To Display empty rooms");
            System.out.println("4: For customer check-out");
            System.out.println("5: Find room from customer name");
            System.out.println("6: To calculate the total hotel bill of the customer");
            System.out.println("7: To calculate food bill of a customer");
            System.out.println("0: To exit");
            System.out.println();
            Option=sc.nextInt();
            System.out.println();
            if(Option==0)
            {
                System.out.println("      THANK YOU");
                break;
            }
            if (Option==1)
            { 
                obj.view(hotel,day);  
            }
            if (Option==2)
            {
                System.out.println("Enter room number(1-10)");
                System.out.println("even number for normal suite and odd for holiday suite");
                roomNum =sc.nextInt();
                System.out.println("Enter name for room "+roomNum+" : ") ;
                Customer=sc.next();
                System.out.print("Enter the number of days the customer is going to stay :");
                int days=sc.nextInt();
                hotel[roomNum]=Customer;
                day[roomNum]=days;
                System.out.println(hotel[roomNum]+" checked in");
                obj.add(hotel,day);
                System.out.println();
            }
            if (Option==3)  
            { 
                obj.vacant(hotel); 
            }
            if (Option==4)
            { 
                view(hotel,day);
                System.out.println("Enter the room from which the customer is checking out: ");
                roomNum = sc.nextInt();
                obj.hotel_bill(day,roomNum);
                System.out.println(hotel[roomNum]+" checked out");
                hotel[roomNum] = "empty";
                obj.delete(hotel,day);
                System.out.println("");
            }
            if (Option==5)
            { 
                obj.find(hotel,day); 
            }
            if (Option==6)
            {
                hotel[roomNum]="empty";
                obj.hotel_bill(day,roomNum);
            }
            if(Option==7)
            {
                obj.display1();
                obj.order1();
                obj.display2();
                obj.order2();
                obj.calculate();
                obj.bill();
                obj.payment();
            }
        }
    }

    void initialise(String hotelRef[])
    {
        for (int x=1;x<11;x++ )
            hotelRef[x] = "empty";
        System.out.println( "   ***Welcome to Hotel Paradise***");
    }

    static void view(String hotel[],int day[])
    {
        for (int x=1;x<11;x++)
        {
            if (hotel[x]==("empty"))
                System.out.println("room "+x+" is empty");
            else {
                System.out.println("room "+x+" is occupied by "+hotel[x]+" for "+day[x]+" days");
            }
        }
    }

    void add(String hotel[],int day[])
    {
        for(int x=1;x<=10;x++)
        {
            if (hotel[x]==("empty"))
                System.out.println("room "+x+" is empty");
            else 
            {
                System.out.println("room "+x+" is occupied by "+hotel[x]+" for "+day[x]+" days");
            }
        }
    }

    void vacant(String hotel[])
    {
        int c=0;
        for (int x=1;x<11;x++)
        {
            if (hotel[x]==("empty")) 
            { System.out.println("room "+x+" is empty"); 
                c++;
            }
        }
        if(c==0)
            System.out.println("*****there are no empty rooms*****");
    }

    void delete(String hotel[],int day[])
    { 
        for (int x=1;x<11;x++)
        {
            if (hotel[x]==("empty"))
            { 
                System.out.println("room "+x+" is empty");
            }
            else 
            {
                System.out.println("room "+x+" is occupied by "+hotel[x]+" for "+day[x]+" days");
            }
        }
    }

    void find(String hotel[],int day[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter customer name for room:" );
        String customersname;
        customersname=sc.next();  
        int c=0;
        int x;
        for (x=1;x<11;x++)
        {
            if (hotel[x].equals(customersname))
            {
                c++;
                break;
            }
        }
        if(c==0)
        {
            System.out.println("*****no room is ocupied by "+customersname+"*****");
        }
        else
            System.out.println("*****room "+x+" is occupied by "+customersname+" for "+day[x]+"days *****");
    }

    void hotel_bill(int day[],int r)
    {
        System.out.println("enter room number");
        name=sc.next();
        int type;
        if(r%2==0)
            type=2;
        else
            type=1;
        if(type==1)
        {
            Hotel_bill+=day[r]*2000;
            System.out.println("the customers bill is: "+Hotel_bill);
        }
        else if(type==2)
        {
            Hotel_bill+=day[r]*1200;
            System.out.println("the customers bill is: "+Hotel_bill);
        }
        System.out.println();
        System.out.println("  ***Enter your payment method***");
        System.out.println("1 for card 2 for cash ");
        int p=sc.nextInt();
        if(p==1)
        {
            System.out.println("***enter your details***");
            System.out.println("1:enter full name" );
            String n=sc.next();
            System.out.println(":enter account number");
            long acc=sc.nextInt();
        }
        else if(p==2)
        {
            System.out.println("***enter the amount you are giving***");
            int cash1=sc.nextInt();
            System.out.println("change= "+(cash1-Hotel_bill));
        }
        Hotel_bill=0;
    }

    void display1()
    {
        System.out.println("    WELCOME TO THE KITCHEN" );
        System.out.println("*enter customer's name :");
        name=sc.next();
        System.out.print("*enter room number :");
        roomno=sc.nextInt();
        System.out.println();
        System.out.println("*enter 1 for veg menu,2 for nonveg menu and 3 for mixed menu");
        int ch=sc.nextInt();
        if(ch==1)
        {
            System.out.println();
            System.out.println(" ***TODAYS VEG MENU IS:-");
            System.out.println("    veg thali   =190/-");   
            System.out.println("    pav bhaji   =120/-");   
            System.out.println("    sandwich    =100/-");   
            System.out.println("    paneer sabji=160/-");    
            System.out.println("    roti        =45/- ");   
            System.out.println(" ***BEVRAGES   ");
            System.out.println("    coca cola   =25/- ");    
            System.out.println("    pepsi       =25/- ");
            System.out.println();
            System.out.println(" ***enter 1 for veg thali");
            System.out.println("          2 for pav bhaji");
            System.out.println("          3 for sandwich");
            System.out.println("          4 for paneer sabji");
            System.out.println("          5 for roti");
            System.out.println("          11 for coca cola, ");
            System.out.println("          12 for pepsi");
        }
        else if(ch==2)
        {
            System.out.println();
            System.out.println(" ***TODAYS NON VEG MENU IS:-");
            System.out.println("    non veg thali  =230/-");
            System.out.println("    butter chicken =240/-");
            System.out.println("    fish           =195/-");
            System.out.println("    chicken biryani=170/-"); 
            System.out.println("    chicken curry  =210/-");
            System.out.println(" ***BEVRAGES    ");
            System.out.println("    coca cola      =25/-");    
            System.out.println("    pepsi          =25/-");
            System.out.println();
            System.out.println(" ***enter 6 for non veg thali");
            System.out.println("          7 for butter chicken");
            System.out.println("          8 for  fish");
            System.out.println("          9 for chicken biryani");
            System.out.println("          10 for chicken biryani");
            System.out.println("          11 for coca cola, ");
            System.out.println("          12 for pepsi");
        }
        else if(ch==3)
        {
            System.out.println(" ***TODAYS MENU IS:-");
            System.out.println("    veg thali      =190/-");   
            System.out.println("    pav bhaji      =120/-");   
            System.out.println("    sandwich       =100/-");   
            System.out.println("    paneer sabji   =160/-");    
            System.out.println("    roti           =45/- ");
            System.out.println("    non veg thali  =230/-");
            System.out.println("    butter chicken =240/-");
            System.out.println("    fish           =195/-");
            System.out.println("    chicken biryani=170/-"); 
            System.out.println("    chicken curry  =210/-");
            System.out.println(" ***BEVRAGES    ");
            System.out.println("    coca cola      =25/-");    
            System.out.println("    pepsi          =25/-");
            System.out.println();
            System.out.println(" ***enter 1 for veg thali");
            System.out.println("          2 for pav bhaji");
            System.out.println("          3 for sandwich");
            System.out.println("          4 for paneer sabji");
            System.out.println("          5 for roti");
            System.out.println("          6 for non veg thali");
            System.out.println("          7 for butter chicken");
            System.out.println("          8 for  fish");
            System.out.println("          9 for chicken biryani");
            System.out.println("          10 for chicken biryani");
            System.out.println("          11 for coca cola");
            System.out.println("          12 for pepsi");
        }
        else
            System.out.println("invalid");
    }

    void order1()
    {
        System.out.println();
        System.out.println("**enter the order with the quantity**");
        System.out.println("**enter 0 when your order is complete**");
        for(int i=1;i<=12;i++)
        {
            System.out.print("enter dish "+(i)+" : ");
            ar[i]=sc.nextInt();
            if(ar[i]==0)
            {
                for(int x=i+1;x<=12;x++)
                {
                    ar[x]=0;
                    q[x]=0;
                }
                System.out.println();
                break;
            }
            else
            {
                System.out.print("enter quantity : ");
                q[i]=sc.nextInt();
                System.out.println();
                continue;
            }
        }
    }

    void display2()
    {
        System.out.println("  *did the customer take any desert?");
        System.out.println("  *if yes type 1 else type 2");
        temp=1;
        ans=sc.nextInt();
        if(ans==temp)
        {
            System.out.println("  *DESERTS");
            System.out.println("   vanilla ice-ream   =45/-");
            System.out.println("   chocolate ice-ream =55/-");
            System.out.println("   strawberry ice-ream=50/-");
            System.out.println();
            System.out.println("  *enter 13 for vanilla ice-ream");
            System.out.println("         14 for chocolate ice-ream");
            System.out.println("         15 for strawberry ice-ream");
            temp++;
        }
    }

    void order2()
    {
        if(temp==1)
        {
            for(int x=12;x<=14;x++)
            {
                ar[x]=0;
                q[x]=0;
            }
        }
        else
        {
            for(int x=13;x<=15;x++)
            {
                System.out.print("enter dish:");
                ar[x]=sc.nextInt();
                if(ar[x]==0)
                {
                    for(int d=x+1;d<=15;d++)
                    {
                        ar[d]=0;
                        q[d]=0;
                    }
                    break;
                }
                else
                {
                    System.out.print("enter quantity:");
                    q[x]=sc.nextInt();
                }
            }
        }
    }

    void calculate()
    {
        for(int a=1;a<=15;a++)
        {
            if (ar[a]==1)
                sum+=(190*q[a]);
            else if(ar[a]==2)
                sum+=(120*q[a]);
            else if(ar[a]==3)
                sum+=(100*q[a]);
            else if(ar[a]==4)
                sum+=(160*q[a]);
            else if(ar[a]==5)
                sum+=(45*q[a]);
            else if(ar[a]==6)
                sum+=(230*q[a]);
            else if(ar[a]==7)
                sum+=(240*q[a]);
            else if(ar[a]==8)
                sum+=(195*q[a]);
            else if(ar[a]==9)
                sum+=(170*q[a]);
            else if(ar[a]==10)
                sum+=(210*q[a]);  
            else if(ar[a]==11)  
                sum+=(25*q[a]);  
            else if(ar[a]==12)  
                sum+=(25*q[a]);
            else if(ar[a]==13)  
                sum+=(45*q[a]);
            else if(ar[a]==14)  
                sum+=(55*q[a]);
            else if(ar[a]==15)  
                sum+=(50*q[a]);
            if(ar[a]>15)
                q[a]=0; 
            else
                sum=sum;
        } 
    }

    void bill()
    {
        System.out.println("***************************************");
        System.out.println("            THE paradise  ");
        System.out.println("         rooms food and more ");
        System.out.println("          NAME   : "+name);
        System.out.println("          TABLE NUMBER  : "+roomno);
        System.out.println("              YOUR ORDER ");
        System.out.println("_______________________________________");
        System.out.println("    DISH        PRICE    QUANTITY     |");
        System.out.println("_______________________________________");
        for(int b=0;b<=14;b++)
        {
            if (ar[b]==1)
                System.out.println("veg thali      =190     "+q[b]+"             |");
            else if(ar[b]==2)
                System.out.println("pav bhaji      =120     "+q[b]+"             |");
            else if(ar[b]==3)
                System.out.println("sandwich       =100     "+q[b]+"             |");
            else if(ar[b]==4)
                System.out.println("paneer sabji   =160     "+q[b]+"             |");
            else if(ar[b]==5)
                System.out.println("roti           =45      "+q[b]+"             |");
            else if(ar[b]==6) 
                System.out.println("non veg thali  =230     "+q[b]+"             |");
            else if(ar[b]==7) 
                System.out.println("butter chicken =240     "+q[b]+"             |");
            else if(ar[b]==8)
                System.out.println("fish           =195     "+q[b]+"             |");
            else if(ar[b]==9)
                System.out.println("chicken biryani=170     "+q[b]+"             |");
            else if(ar[b]==10)
                System.out.println("chicken curry  =210     "+q[b]+"             |");
            else if(ar[b]==11)
                System.out.println("coca cola      =25      "+q[b]+"             |");
            else if(ar[b]==12)
                System.out.println("pepsi          =25      "+q[b]+"             |");
        }
        for(int h=1;h<=15;h++)
        {
            if(ar[h]==13)
                System.out.println("v.ice-cream    =45      "+q[h]+"             |");
            else if(ar[h]==14)
                System.out.println("c.ice-cream    =55      "+q[h]+"             |");
            else if(ar[h]==15)
                System.out.println("s.ice-cream    =50      "+q[h]+"             |");
        }
        if(sum==0.0)
            qs=0;
        System.out.println("_______________________________________");
        System.out.println("TOTAL BILL     ="+sum+"                  |");
        System.out.println("_______________________________________");
        System.out.println("all prices are inclusive of sales tax.|");
        System.out.println("***************************************");
    }

    void payment()
    {
        System.out.println();
        System.out.println("  ***Enter your payment method***");
        System.out.println("1 for card 2 for cash ");
        int p=sc.nextInt();
        if(p==1)
        {
            System.out.println("***enter your details***");
            System.out.println("1:enter full name" );
            String n=sc.nextLine();
            System.out.println(":enter account number");
            long acc=sc.nextInt();
            System.out.println("3:enter pin");
            int pin=sc.nextInt();
        }
        else if(p==2)
        {
            System.out.println("***enter the amount you are giving***");
            int cash=sc.nextInt();
            System.out.println("change= "+(cash-sum));
        }

    }
}

