#import <Foundation/Foundation.h>
#import <Foundation/Foundation2.h>
#import <Foundation/Foundation3.h>


@protocol MyProtocol  : ItsSuperclass <p1,p2,p3>
 
- (void)requiredMethod;
 
@optional
- (void)anOptionalMethod;
- (void)anotherOptionalMethod;
 
@required
- (void)anotherRequiredMethod;
 
@end

@interface BlahClass: anotherDummyClass{

int j;
int k;

}

-(void) doSomething:(int)x:(int)y;

-(void) lalala;

@end

