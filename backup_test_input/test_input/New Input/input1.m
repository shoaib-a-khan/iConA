@interface dummyClass: anotherDummyClass{

int j;
int k;

}

-(void) doSomething:(int)x:(int)y;

-(void) lalala;

@end

@implementation Dummyclass


+(void) main:(String) args{


 NSMutableArray *arr=[[NSMutableArray alloc] initWithCapacity:10];
        
        [arr addObject:@"Im 1"];
        [arr addObject:@"Im 2"];
        [arr addObject:@"Im 3"];

        for(int i=0;i<[arr count];i=i+1){
		  	[arr objectAtIndex:i];
        }
        
        [arr removeLastObject];

        for(int i=0;i<[arr count];i=i+1){
		  	[arr objectAtIndex:i];
        }
}

@end



