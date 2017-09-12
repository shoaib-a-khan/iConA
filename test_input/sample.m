
#import <Foundation/Foundation4.h>
#import <Foundation/Foundation5.h>
void GlobalFunction()
{
	a=5;
	b=4;

}


void GlobalFunction2()
{
	a=5;
	b=4;

}

@implementation BlahClass

-(void) GlobalFunction{

}


-(void) doSomething:(int)x:(int)y{

int k;
GlobalFunction();
GlobalFunction2();
}
-(void) doNothing{

}

@end