
#import <Foundation/Foundation6.h>
#import <Foundation/Foundation7.h>
#import <Foundation/Foundation8.h>

@implementation MYClass

- (void) test{
         
     const int maxNum=100;
        NSMutableArray *arr=[[NSMutableArray alloc] initWithCapacity:10];
        
    for(int k=0;k<maxNum;k++)
    {
        float f=k;
        [arr addObject:[NSNumber numberWithInt:k]];
    }
        
        [arr addObject:@"Im 1"];
        [arr addObject:@"Im 2"];
        [arr addObject:@"Im 3"];

        for(int i=0;i<[arr count];i=i+1){
		  	NSLog(@"%@",[arr objectAtIndex:i]);
        }
        
        [arr removeLastObject];

        for(int i=0;i<[arr count];i=i+1){
		  	NSLog(@"%@",[arr objectAtIndex:i]);
        }
    
    for(int k=101;k<120;k++){
        [arr addObject:[NSNumber numberWithInt:k]];
    }
         for(int i=0;i<[arr count];i=i+1){
             NSLog(@"%@",[arr objectAtIndex:i]);
         }
         
    
    return 0;
}



@end