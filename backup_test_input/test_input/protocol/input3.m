
@protocol MyProtocol <p1,p2,p3>
 
@required
- (void)requiredMethod1;
+ (void)requiredMethod2;


@optional
- (void)optionalMethod1;
+ (void)optionalMethod2;
 

+(void) defaultMethod1;
-(void) defaultMethod2;

@end

